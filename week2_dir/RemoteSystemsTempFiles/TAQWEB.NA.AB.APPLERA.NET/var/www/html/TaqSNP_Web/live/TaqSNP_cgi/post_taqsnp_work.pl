#!/usr/bin/perl -w
#
# Post-mortem after TaqSNP runs on interface
# meant to be kicked off by TaqSNP.sh
# new plan: run it as a cron job looking
# for .out file
#
#############################################
use lib '/var/www/html/TaqSNP_Web/live/TaqSNP_cgi';
#use lib '/usr/local/perl/lib/site_perl/5.8.0';
use lib '/home/langitem/lib/site_perl/5.8.0';

use Mail::Send;
use MIME::Lite;
use strict;
use Order_Submit;
#############################################
## Set some basic vars based on configuration files
our $env = get_env();
our $logDir = $env->{"logDir"};
our $jobDir = $env->{"jobDir"};
our $projectDir = $env->{"projectDir"};
our $jobList = $env->{"jobList"};
our $finishedList = $env->{"finishedList"};
our $TaqSNP = $env->{"TaqSNP"};
our $adminEmail = $env->{"adminEmail"};
our $winJobDir = $env->{"winJobDir"};
our $winProjectDir = $env->{"winProjectDir"};
#############################################
## Set some date vars for use by the rest of the script
our $num_date = time();
our $date = localtime($num_date);
#############################################

# Open log and error files
open (STDOUT,">>$logDir/postfile_log");
open (STDERR,">>$logDir/postfile_err");

our $params = {};


# First look for new jobs
# Here, "new" just means not-yet-postprocessed
# They may or may not be completed
my $done_jobs = find_done_jobs($jobList);
exit unless ($done_jobs);

foreach my $done_job(@$done_jobs)
{
	# Re-initialize $params for this job
	$params = {};

	# Get job parameters so we know what we're doing
	$params = read_job_file($done_job);
	next unless($params);

	next unless get_timestamps( );

        # Compare the new design with existing assays if any
        next unless compareDesign();

	# Give up if can't create GOO submission file
        if($params->{"Genome database for QC"} eq 'none'){
	  next unless createSubmitForm_noQC();
        } else {
	  next unless createSubmitForm();
        }

	# Count beginning SNPs and ending assays to determine if not all
	next unless check_snp_fates( );

	# Find failed SNPs in taqpipe.error and get the error messages
	next unless read_taqpipe_error( );

	# Send email to user that project is done
	warn ("Couldn't send email for $done_job") unless send_email( );
}


##################################################
###  SUBS  #######################################
##################################################
sub find_done_jobs
{
	my @done_jobs;
	my @jobs_in_dir = `ls $jobDir`;
	chomp @jobs_in_dir;

        unless (open(FINISHED, $finishedList)){
             warn "Couldn't open $finishedList for reading.\n";
             return 0;
        }

        my @finished_jobs = <FINISHED>;
        my %finished_jobs;
        foreach my $line(@finished_jobs)
        {
                my ($finished_job) = split("\t",$line);
                $finished_job =~ s/DONE=//;
                $finished_jobs{$finished_job} = $date;
        }

	unless ( open (JOBS,">>$finishedList") )
	{
		warn "Couldn't open $finishedList for appending\n";
		return 0;
	}

	foreach my $job_in_dir(@jobs_in_dir)
	{
		my $dir;
		my $out;
		my $has_dir;
		my $incomplete = 0;
		my $project_path;

		# First, check to see if it's already postprocessed
		# and move on if it is
		next if (exists $finished_jobs{$job_in_dir});

		# Now that we know it's not postprocessed, check to see if it's done
		foreach my $type qw(SNP INDEL)
		{
			$project_path = "$projectDir/$job_in_dir";
			$dir = "$project_path/$type";

			# Move on if there is no directory of this type
			next unless (-d $dir);

			# Mark that it has a type directory so we can kill
			# it if it doesn't have any type directory
			$has_dir++;

			$out = "$project_path/$type/end_file";

			# Mark as unfinished if there is no out file
			unless (-f $out)
			{
				$incomplete++;
				next;
			}

		}

		# Party's really over if there's no SNP or INDEL directory
		unless ($has_dir)
		{
			warn "No SNP or INDEL directory found in $job_in_dir\n";
			#print JOBS "DONE=$job_in_dir\t$date\n";
			next;
		}

		# And party's over if either directory was missing its "out"
		# file
		next if ($incomplete);

		# Now we know we have a finished one
		print JOBS "DONE=$job_in_dir\t$date\n";

		print "Completed job found: $job_in_dir\n";

		push @done_jobs, $job_in_dir;
	}

	close JOBS;

	return 0 unless @done_jobs > 0;

	return \@done_jobs;
} # end of find_done_jobs subroutine

sub get_timestamps
{
	my $project_name = $params->{"Project Name"};
	my $project_path = "$projectDir/$project_name";

	$params->{"PROJECT PATH"} = $project_path;

	my $out;
	foreach my $type qw(SNP INDEL)
	{
		next unless (-d "$project_path/$type");

		# Get pipeline ending time from timestamp file
		# date_find converts readable dates to epoch seconds
		# for date math
		my $end_file = "$project_path/$type/end_file";
		$params->{"${type}_OUT"} = $end_file;
		#my $file_date =  join(" ",(split(" ",`ls -l $out`))[5..7]);
		my $file_date = `cat $end_file`;
		chomp $file_date;
		$params->{"${type}OUT_DATE"} = date_find($file_date);

		# Get pipeline starting time from timestamp file
		my $start_file = "$project_path/$type/start_file";
		$params->{"${type}_IN"} = $start_file;
		#my $start_date =  join(" ",(split(" ",`ls -l $start_file`))[5..7]);
		my $start_date = `cat $start_file`;
		chomp $start_date;
		$params->{"${type}IN_DATE"} = date_find($start_date);
	}

	# Get starting timestamp from job file in project directory
	#my $jobfile = "$project_path/$project_name";
	#my $job_start =  join(" ",(split(" ",`ls -l $jobfile`))[5..7]);
	#$params->{"START_DATE"} = date_find($job_start);

	return 1;
} # end of get_timestamps subroutine

sub createSubmitForm
{
	my $project_name = $params->{"Project Name"};
	my $project_path = "$projectDir/$project_name";
	my $all_snp_results = "${project_name}_results.xls";
	$params->{"ALL RESULTS"} = $all_snp_results;
	$params->{"PROJECT PATH"} = $project_path;

	my $submit_file = "${project_name}_submit.txt";
	$params->{"SUBMIT FILE"} = $submit_file;

	my @lines;
	# look through SNP and INDEL for the file with "selected" in its name
	foreach my $type qw(SNP INDEL)
	{
		next unless (-d "$project_path/$type");

		$params->{$type} = 1;

		my @files = `ls "$project_path/$type"`;
		my ($output_file) = grep /\.newdesign$/,@files;

		unless ($output_file)
		{
			$params->{"OUTPUT FAILURES"} = "No TaqSNP assay output file was found for this project";
			next;
		}

		chomp $output_file;

		unless (open (FILE, "$project_path/$type/$output_file") )
		{
			warn "Couldn't open output file $output_file for reading: \n";
			return 0;
		}
		push @lines, <FILE>;

		close FILE;
	}

	# Party's over if you can't create the submission file
	unless ( open(OUT,">${project_path}/$submit_file") )
	{
		warn "Couldn't create submission file: $submit_file\n";
		return 0;
	}

	unless (open (RESULTS,">$project_path/$all_snp_results") )
	{
		warn "Couldn't create results file: $all_snp_results";
		return 0;
	}

	my @keys;
	foreach my $line(@lines)
	{
		# keep going until you find the header line
		next unless ($line =~ /^UID/);

		print RESULTS $line;

		# Get the header fields
		@keys = split("\t",$line);

		last;
	}


	my %data;
	foreach my $line(@lines)
	{
		my %fields;
		# Skip it if it's the header line, we've already
		# taken care of that
		next if ($line =~ /^UID/);

		print RESULTS $line;

		my @cols = split("\t",$line);

		# using a hash slice, assign all of the fields in the line to the %fields hash (it's not an array!)
		@fields{@keys} = @cols;

		my $id = $fields{"UID"};
		if ($id =~ /^(\S+)::\d+$/)
		{
			# first, clean up UID
			$id = $1;
			$fields{"UID"} = $id;
		}

		my $final_score = $fields{"FinalScore"};
                my $pset_score = $fields{"PsetScore"};
                my $genome_p = $fields{"GenomeP"};

		push @{$data{$id}{$final_score}{$genome_p}{$pset_score}}, \%fields;
	}

	# Now, go through, find the best assay, make oligo IDs, and print out
	foreach my $id(keys %data)
	{
                # Get the highest final score
                my @fscores = sort {$b<=>$a} (keys %{$data{$id}});
                my $high_fscore = shift @fscores;

		# Get the lowest genome penalty
		my @gpens = sort {$a<=>$b}(keys %{$data{$id}{$high_fscore}});
		my $low_gpen = shift @gpens;

		# Get the highest pset score
		my @psets = sort {$b<=>$a}(keys %{$data{$id}{$high_fscore}{$low_gpen}});
		my $high_pset = shift @psets;

		# Get the assay with this pset and genome penalty
		my @assays = @{$data{$id}{$high_fscore}{$low_gpen}{$high_pset}};
		my $assay = shift @assays;

		###   Adjust IDs   ###
		my $temp;
		my $shortid;
		if($id =~ /^hCV/) 		# Celera SNPs
		{
			$temp = sprintf "%10d", substr($id, 3);
			$temp =~ tr/ /_/;
			$shortid = "C" .$temp."_10";
		}
		elsif($id =~ /IMS-JST/) # Nakamura SNPs
		{
			$shortid="N" . substr($id, 7);
		}
		else					# other External SNPs
		{
			# Shorten ID to 10 characters if it's over 10 characters
			$id = substr($id,0,10) if (length ($id) >10);

			# Pad ID to 10 characters if it's shorter than 10 characters.
			$temp = sprintf "%10s", $id;
			$temp =~ tr/ /_/;
			$shortid="E" .$temp."_10";
		}

		# Append vic, fam, forward, reverse indicators to probe and primer IDs
		my $fpname=$shortid . "F";
		my $pb1name=$shortid . "V" . ($assay->{"ProbeDir"} eq "Forward"?1:2);
		my $pb2name=$shortid . "M" . ($assay->{"ProbeDir"} eq "Forward"?1:2);
		my $rpname=$shortid . "R";

		my $probe1 = $assay->{"ProbeSeq1"};
		my $probe2 = $assay->{"ProbeSeq2"};
		my $forseq = $assay->{"ForSeq"};
		my $revseq = $assay->{"RevSeq"};

		print OUT join("\t",$pb1name,$pb2name,$fpname,$rpname), "\n";
		print OUT join("\t","VIC-${probe1}","6FAM-${probe2}",$forseq,$revseq),"\n";

	}
	close OUT;
	close RESULTS;

	# Store the number of output IDs for later
	my @output_ids = keys %data;
	$params->{"OUTPUT IDS"} = \@output_ids;

	return 1;
}

sub createSubmitForm_noQC
{
	my $project_name = $params->{"Project Name"};
	my $project_path = "$projectDir/$project_name";
	my $all_snp_results = "${project_name}_results.xls";
	$params->{"ALL RESULTS"} = $all_snp_results;
	$params->{"PROJECT PATH"} = $project_path;

	my $submit_file = "${project_name}_submit.txt";
	$params->{"SUBMIT FILE"} = $submit_file;

	my @lines;
	# look through SNP and INDEL for the file with "selected" in its name
	foreach my $type qw(SNP INDEL)
	{
		next unless (-d "$project_path/$type");

		$params->{$type} = 1;

		my @files = `ls "$project_path/$type"`;
		my ($output_file) = grep /\.newdesign$/,@files;

		unless ($output_file)
		{
			$params->{"OUTPUT FAILURES"} = "No TaqSNP assay output file was found for this project";
			next;
		}

		chomp $output_file;

		unless (open (FILE, "$project_path/$type/$output_file") )
		{
			warn "Couldn't open output file $output_file for reading: \n";
			return 0;
		}
		push @lines, <FILE>;

		close FILE;
	}

	# Party's over if you can't create the submission file
	unless ( open(OUT,">${project_path}/$submit_file") )
	{
		warn "Couldn't create submission file: $submit_file\n";
		return 0;
	}

	unless (open (RESULTS,">$project_path/$all_snp_results") )
	{
		warn "Couldn't create results file: $all_snp_results";
		return 0;
	}

	my @keys;
	foreach my $line(@lines)
	{
		# keep going until you find the header line
		next unless ($line =~ /^UID/);

		print RESULTS $line;

		# Get the header fields
		@keys = split("\t",$line);

		last;
	}


	my %data;
	foreach my $line(@lines)
	{
		my %fields;
		# Skip it if it's the header line, we've already
		# taken care of that
		next if ($line =~ /^UID/);

		print RESULTS $line;

		my @cols = split("\t",$line);

		# using a hash slice, assign all of the fields in the line to the %fields hash (it's not an array!)
		@fields{@keys} = @cols;

		my $id = $fields{"UID"};
		if ($id =~ /^(\S+)::\d+$/)
		{
			# first, clean up UID
			$id = $1;
			$fields{"UID"} = $id;
		}

		my $final_score = $fields{"FinalScore"};
		my $pset_score = $fields{"PsetScore"};

		push @{$data{$id}{$final_score}{$pset_score}}, \%fields;
	}

	# Now, go through, find the best assay, make oligo IDs, and print out
	foreach my $id(keys %data)
	{
                # Get the highest final score
                my @fscores = sort {$b<=>$a} (keys %{$data{$id}});
                my $high_fscore = shift @fscores;

		# Get the highest pset score
		my @psets = sort {$b<=>$a}(keys %{$data{$id}{$high_fscore}});
		my $high_pset = shift @psets;

		# Get the assay with this pset and genome penalty
		my @assays = @{$data{$id}{$high_fscore}{$high_pset}};
		my $assay = shift @assays;

		###   Adjust IDs   ###
		my $temp;
		my $shortid;
		if($id =~ /^hCV/) 		# Celera SNPs
		{
			$temp = sprintf "%10d", substr($id, 3);
			$temp =~ tr/ /_/;
			$shortid = "C" .$temp."_10";
		}
		elsif($id =~ /IMS-JST/) # Nakamura SNPs
		{
			$shortid="N" . substr($id, 7);
		}
		else					# other External SNPs
		{
			# Shorten ID to 10 characters if it's over 10 characters
			$id = substr($id,0,10) if (length ($id) >10);

			# Pad ID to 10 characters if it's shorter than 10 characters.
			$temp = sprintf "%10s", $id;
			$temp =~ tr/ /_/;
			$shortid="E" .$temp."_10";
		}

		# Append vic, fam, forward, reverse indicators to probe and primer IDs
		my $fpname=$shortid . "F";
		my $pb1name=$shortid . "V" . ($assay->{"ProbeDir"} eq "Forward"?1:2);
		my $pb2name=$shortid . "M" . ($assay->{"ProbeDir"} eq "Forward"?1:2);
		my $rpname=$shortid . "R";

		my $probe1 = $assay->{"ProbeSeq1"};
		my $probe2 = $assay->{"ProbeSeq2"};
		my $forseq = $assay->{"ForSeq"};
		my $revseq = $assay->{"RevSeq"};

		print OUT join("\t",$pb1name,$pb2name,$fpname,$rpname), "\n";
		print OUT join("\t","VIC-${probe1}","6FAM-${probe2}",$forseq,$revseq),"\n";

	}
	close OUT;
	close RESULTS;

	# Store the number of output IDs for later
	my @output_ids = keys %data;
	$params->{"OUTPUT IDS"} = \@output_ids;

	return 1;
} # end of createSubmitForm_noQC subroutine

sub check_snp_fates
{
	# Compare number of SNPs in .fas file to number of SNPs with assays
	# in the output file
	my $project_path = $params->{"PROJECT PATH"};
	my $project_name = $params->{"Project Name"};
	my $output_ids = $params->{"OUTPUT IDS"};
	my $assay_targets;

	# First get the number of input sequences by gathering up the
	# fasta data
	my @all_fasta;
	foreach my $type qw(SNP INDEL)
	{
		my $dir = "$project_path/$type";

		next unless (-d $dir);

		my $fasta = "$dir/${project_name}_${type}.fas";
		unless (open (FAS, "$fasta") )
		{
			warn "Couldn't open fasta file $fasta: $!\n";
			next;
		}

		# Gather up all of the input sequences
		push @all_fasta, <FAS>;
		close FAS;
	}

	chomp @all_fasta;
	my @headers = grep /^>(\S+)$/, @all_fasta;
	my $num_input = @headers;

	# If the numbers match we can go home.
	return 1 if ($num_input == @$output_ids);


	# Make a super-fast hash with a slice
	my %output_ids;
	@output_ids{@$output_ids} = ((1) x @$output_ids);

	# Otherwise, we have to figure out what the difference is.
	my @failed;
	foreach my $header(@headers)
	{
		# In case the > is still there...
		$header =~ s/>//;

		# Keep going if the header made it to the output
		next if (exists $output_ids{$header} );
		push @failed, $header;
	}
	my $num_failed = @failed;
	print "Found $num_failed failed headers for $project_name: ", join(",",@failed),"\n" if (@failed > 0);

	$params->{"FAILED HEADERS"} = \@failed;

	return 1;
} # end of check_snp_fates subroutine

sub read_taqpipe_error
{
	my $project_path = $params->{"PROJECT PATH"};

	my @lines;
	foreach my $type qw(SNP INDEL)
	{
		next unless (-d "$project_path/$type");

		$params->{$type} = 1;

		my @files = `ls "$project_path/$type"`;
		my ($output_file) = grep /taqpipe.error/,@files;

		chomp $output_file;

		unless (open (FILE, "$project_path/$type/$output_file") )
		{
			warn "Couldn't open output file $output_file for reading: \n";
			return 0;
		}
		push @lines, <FILE>;

		close FILE;
	}

	my @failure_messages = grep /^Failed/, @lines;
	chomp @failure_messages;

	$params->{"TAQPIPE FAILURES"} = \@failure_messages;

	return 1;
} # end of read_taqpipe_error subroutine

sub send_email
{
	my $email = $params->{"Email Address"};
	my $project_name = $params->{"Project Name"};
	my $win_job_path = $winProjectDir . "\\" . $params->{"Project Name"};
	my $submit_file = $params->{"SUBMIT FILE"};
	my @parameter_list = split(",",$params->{"Parameter List"});
	my $all_snp_results = $params->{"ALL RESULTS"};
	my $start_date = $params->{"DATE"};
	my $project_path = $params->{"PROJECT PATH"};
	my $end_date = time();
        my $compare_results = $params->{"COMPARE RESULTS"};

	#my $time_diff = date_calc($start_date,$end_date);
	#my $start = localtime($start_date);
	#my $finish = localtime($end_date);

	my $start_pipeline;
	if ($params->{"SNPIN_DATE"} && $params->{"INDELIN_DATE"})
	{
		$start_pipeline = $params->{"SNPIN_DATE"} < $params->{"INDELIN_DATE"} ?
		                  $params->{"SNPIN_DATE"} : $params->{"INDELIN_DATE"};
	}
	elsif ($params->{"SNPIN_DATE"})
	{
		$start_pipeline = $params->{"SNPIN_DATE"};
	}
	elsif ($params->{"INDELIN_DATE"})
	{
		$start_pipeline = $params->{"INDELIN_DATE"};
	}
	else
	{
		warn "No start date determined for $project_name\n";
	}

	my $finish_pipeline;
	if ($params->{"SNPOUT_DATE"} && $params->{"INDELOUT_DATE"})
	{
		$finish_pipeline = $params->{"SNPOUT_DATE"} < $params->{"INDELOUT_DATE"} ?
						  $params->{"SNPOUT_DATE"} : $params->{"INDELOUT_DATE"};
	}
	elsif ($params->{"SNPOUT_DATE"})
	{
		$finish_pipeline = $params->{"SNPOUT_DATE"};
	}
	elsif ($params->{"INDELOUT_DATE"})
	{
		$finish_pipeline = $params->{"INDELOUT_DATE"};
	}
	else
	{
		warn "No finish date determined for $project_name\n";
	}
	my $time_diff = date_calc($start_pipeline,$finish_pipeline);

	my $assay_submit_path = $win_job_path . "\\" . $submit_file;
	my $results_path =  $win_job_path . "\\" . $all_snp_results;

	my $failed_SNP_message;
	my @failed_headers;
	my $num_failed;
	if ($params->{"FAILED HEADERS"} && @{$params->{"FAILED HEADERS"}} > 0)
	{
		$num_failed = scalar(@{$params->{"FAILED HEADERS"}});
		@failed_headers = map { '<li class="indent">' . $_ . "</li>" } @{$params->{"FAILED HEADERS"}};
		$failed_SNP_message = '<p class="indent">' . "The following $num_failed assay targets were in the submission but did not have assays in the output:</p>\n" . '<ul class="taqpipe">' . join("\n", @failed_headers) . "\n</ul>";
	}
	else
	{
		$failed_SNP_message = '<p class="indent">' . "All assay targets present in the submission were found in the output.</p>";
	}

	my $taqpipe_failure_message;
	my $num_taqpipe_failed;
	my @taqpipe_failed;
	if ($params->{"TAQPIPE FAILURES"} && @{$params->{"TAQPIPE FAILURES"}} > 0)
	{
		$num_taqpipe_failed = scalar(@{$params->{"TAQPIPE FAILURES"}});
		@taqpipe_failed = map { '<li class="indent">' . $_ . "</li>" } @{$params->{"TAQPIPE FAILURES"}};
		$taqpipe_failure_message = '<p class="indent">' . "The following $num_taqpipe_failed TaqPipe failures were found:</p>\n" .  '<ul class="taqpipe">' . join("\n", @taqpipe_failed) . "\n</ul>";
	}
	else
	{
		$taqpipe_failure_message = '<p class="indent">' . "No TaqPipe failures found.</p>";
	}

	#$email =~ s/\s+/,/g;

my $message = "";

$message .= <<EOM;
<html>

<head>
<style type="text/css">
p {
	font-family: Verdana, Helvetica, sans-serif;
}

.inline {
	display: inline;
}

ul {
	font-family: Verdana, Helvetica, sans-serif;

}
ul.taqpipe {
	margin-left: 1cm;
	padding-left: 1cm;
	list-style-position: inside;
	color: #330099;

}
li {
	font-family: Verdana, Helvetica, sans-serif;
}

.indent {
	margin-left: 1cm;
	color: #330099;
}

h2 {
	font-family: Verdana, Helvetica, sans-serif;
}

.path {
	margin-left: 1cm;
	font-style: normal;
	color: #330099;
}

div.emphasis{
	font-family: Verdana, Helvetica, sans-serif;
	color: #330099;
	font-weight: bold;
	display: inline;
}
</style>
</head>

<body>
<hr>
<h2>Dear TaqSNP Web User:</h2>

<p>Your TaqSNP web order for $project_name has now completed.  Pipeline
output for your project can be found in the following location:</p>

<p class="path">$win_job_path</a></p>

EOM

	if ($params->{"OUTPUT FAILURES"})
	{

$message .= <<EOM;

<p>A problem has been detected:</p>

	<p class="indent">$params->{"OUTPUT FAILURES"}</p>

<p>Other status messages:</p>

	$failed_SNP_message

	$taqpipe_failure_message

<p>Please contact the TaqSNP Web team to assist you if you cannot
resolve this problem.</p>
EOM

	}

	else
	{

$message .= <<EOM;

<p class="inline">The assay submission file, </p><div class="emphasis">$submit_file</div>
<p class="inline"> is attached to the top of
this message. If multiple assays were designed per SNP, then assays
were prioritized first by genome penalty (low to high) and then the
assays with the lowest genome penalty were prioritized by PSET score
(high to low) and then only the highest-priority assay was included
in the submission file.</p>

<p class="inline">The results file, </p><div class="emphasis">$all_snp_results</div>
<p class="inline"> also attached above, contains all
of the assays that were designed, along with quality scores and other data.</p>

EOM

# Add the email message part for the assay comparison results
if (-f "$project_path/$compare_results" && -s "$project_path/$compare_results"){
$message .= <<EOM;
<p class="inline">There are existing assay(s) in SNPDB for
the target SNP(s). The newly designed assay(s) are compared with the existing assay(s),
the comparison results </p><div class="emphasis">$compare_results</div>
<p class="inline"> are attached above.</p>
EOM
} # end of if

$message .= <<EOM;
<p>Other status messages:</p>

	$failed_SNP_message

	$taqpipe_failure_message

EOM

} # end of else

$message .= <<EOM;

<p>This order took $time_diff to complete.</p>

<p>Thank you for using the TaqSNP Web Interface.</p>
<hr>
</body>
</html>
EOM

	my $settings = "";
	
	$settings .=  "\n\nOrder Settings: \n\n";
	
	foreach my $param(split(",",$params->{"Parameter List"}) )
	{
		next if ($param eq "SNP" ||
				 $param eq "INDEL" ||
				 $param eq "Assay Target" ||
				 $param eq "SNP_PEX" ||
				 $param eq "DATE" ||
				 $param eq "Parameter List"
				 );
	
		$settings .=  "$param:\t$params->{$param}\n";
	}

# Now you are done creating completion message.

	# Create a file and print completion message to it
	my $email_msg = "$project_path/completion_mesg.html";
	if (open (EM, ">$email_msg"))
	{
		print EM $message;
		close EM;
	}
	else
	{
		warn "Could not open message $email_msg: $!\n";
	}

	# Now create an email and print completion message to it.
	my $msg;
	#my $ef;

	$msg = MIME::Lite->new(To      => $email,
			       Cc      => "$adminEmail",
	                       Subject => "TaqSNP Web Order Completion: $project_name",
                       	   Type    => 'multipart/mixed',
                           'Reply-To' => "emanuel.langit\@lifetech.com");

	$msg->attach(Type        => 'TEXT',
				 Disposition => 'attachment',
				 Path        => "$project_path/$submit_file",
	             Filename    => $submit_file) if (-f "$project_path/$submit_file" &&
	                                              -s "$project_path/$submit_file");

	$msg->attach(Type        => 'TEXT',
				 Disposition => 'attachment',
				 Path        => "$project_path/$all_snp_results",
	             Filename    => $all_snp_results) if (-f "$project_path/$all_snp_results" &&
	                                                  -s "$project_path/$all_snp_results");

	$msg->attach(Type        => 'TEXT',
				 Disposition => 'attachment',
				 Path        => "$project_path/$compare_results",
	             Filename    => $compare_results) if (-f "$project_path/$compare_results" &&
	                                                  -s "$project_path/$compare_results");

	$msg->attach(Type        => 'text/html',
				 Disposition => 'inline',
             	 Data        => $message);

	$msg->attach(Type        => 'TEXT',
				 Disposition => 'inline',
             	 Data        => $settings);

	$msg->send( );

	return 1;

} # end of send_email subroutine

# Compare the new design with the existing design if the SNP has been designed before:
# Pull out the assay record from SNPDB using the hCV accession, compare the probes and primers
# with the new design - added by Matt Xia.
sub compareDesign
{
	my $project_name = $params->{"Project Name"};
	my $project_path = "$projectDir/$project_name";
	my $comp_results = "${project_name}_compare.xls";
	$params->{"COMPARE RESULTS"} = $comp_results;
	$params->{"PROJECT PATH"} = $project_path;
        my %oldsame = ();  # assays already exist in SNPDB

        unless(open(OUT, ">$project_path/$comp_results"))
        {
              warn "Couldn't open output file $comp_results for writing\n";
              return 0;
        }

	foreach my $type qw(SNP INDEL)
	{
	next unless (-d "$project_path/$type");
	$params->{$type} = 1;

	my @files = `ls "$project_path/$type"`;
	my ($output_file) = grep /all\..*\.xls$|\.taqlog\.xls$/,@files;

	unless ($output_file)
	{
		$params->{"OUTPUT FAILURES"} = "No TaqSNP assay design output file was found for this project";
		next;
	}

	chomp $output_file;

	unless (open (FILE, "$project_path/$type/$output_file") )
	{
		warn "Couldn't open design output file $output_file for reading\n";
		return 0;
	}

	unless (open (MODFILE, ">$project_path/$type/$output_file.newdesign") )
	{
		warn "Couldn't open output file $output_file.newdesign for writing\n";
		return 0;
	}

     # Compare the new design with the existing one if any
     my (@assayHeader, %assay);
     use DBI;
  
     $ENV{ORACLE_HOME} = '/u01/app/oracle/product/Ora9i';
     my $dbh=DBI->connect("dbi:Oracle:host=pluto.pe-c.com;sid=snpprod","vaprod_read","welcome") || die "Cannot make connection\n";

    my $sth_snp = $dbh->prepare("select distinct hcv from snpowner.result_hcv_rs_snp where rs_number = ?");
 
    my $sth_va = $dbh->prepare("select distinct assay_name,upper(vic_seq),VIC_TM,upper(fam_seq),FAM_TM,upper(fwd_seq),FWD_TM,upper(rev_seq),REV_TM,AMP_SEQ,AMP_SEQ_LENGTH,obsolete,obsolete_note from vaprod.T_TAQ_VTASSAY where accession = ? order by assay_name");

    my $sth_adc = $dbh->prepare("select distinct assay_name,upper(vic_seq),VIC_TM,upper(fam_seq),FAM_TM,upper(fwd_seq),FWD_TM,upper(rev_seq),REV_TM,AMP_SEQ,AMP_LENGTH from snpowner.T_TAQ_ASSAY where accession = ? and assay_name is not null order by assay_name");

    my $sth_adc_prod = $dbh->prepare("select distinct obsolete,obsolete_note from snpowner.T_ECOMMERCE_ALL_ENTRY where assay_name = ?");

     while(my $fline = <FILE>){
        my @arr=split /\t/, $fline;
        if($fline =~ /^UID/){ @assayHeader = @arr; print MODFILE $fline; next }
        for(my $i = 0; $i < @arr; $i++){ $assay{$assayHeader[$i]} = $arr[$i]; }
        $assay{ProbeSeq1} = uc($assay{ProbeSeq1});
        $assay{ProbeSeq2} = uc($assay{ProbeSeq2});
        $assay{ForSeq} = uc($assay{ForSeq});
        $assay{RevSeq} = uc($assay{RevSeq});
        my @ampdim=split(/ /,$assay{AmpDims1}); # Get the amplicon size

        # Convert the hcv and rs number to hCV standard in SNPDB
        my $snpid = $assay{UID}; my ($hcv_number, $cv_number);
        $snpid =~ s/ //g;
        $snpid =~ s/::\d+$//; # clean up the UID

        if($snpid =~ /^hcv(\d+)$/i){ $hcv_number = "hCV$1";  $cv_number = "CV$1" }
        elsif($snpid =~ /^rs(\d+)$/i){ # convert the rs number to hcv
            $snpid = "rs$1";
            $sth_snp->execute($snpid) or die $dbh->errstr;
            ($hcv_number) = $sth_snp->fetchrow_array;
            if($hcv_number){ $hcv_number =~ /hcv(\d+)/i or die; $cv_number = "CV$1"; }
        }

        unless($hcv_number){
           print MODFILE $fline;
           next;
        }

        my $comp_out = ''; my $exist_assay = 0;

        $comp_out .= "TARGET_NAME\tVIC_PROBE\tVIC_TM\tFAM_PROBE\tFAM_TM\tFWD_PRIMER\tFWD_TM\tREV_PRIMER\tREV_TM\tASSAY_TYPE\t100% IDENTITY\tVIC_IDENTITY\tFAM_IDENTITY\tFWD_IDENTITY\tREV_IDENTITY\tAMP_SEQ\tAMP_SIZE\tOBSOLETE\tOBSOLETE_NOTE\n";
        $comp_out .= "$assay{UID}\t$assay{ProbeSeq1}\t$assay{ProbeTm1}\t$assay{ProbeSeq2}\t$assay{ProbeTm2}\t$assay{ForSeq}\t$assay{ForTm}\t$assay{RevSeq}\t$assay{RevTm}\tNew Design\t-\t-\t-\t-\t-\t$assay{AmpSeq1}\t$ampdim[2]\t-\t-\n";

        # compare with existing VA assays
        $sth_va->execute($hcv_number) or die $dbh->errstr;
        while(my($assay_name,$vic_seq,$vic_tm,$fam_seq,$fam_tm,$fwd_seq,$fwd_tm,$rev_seq,$rev_tm,$amp_seq,$amp_len,$obsolete,$obs_note)=$sth_va->fetchrow_array){
           my($vic_sim,$fam_sim,$fwd_sim,$rev_sim,$all_sim)=('N','N','N','N','N');

           my $assay_type;
           $obs_note = '-' unless $obs_note;
           $obs_note =~ s/^\s*\;\s*//g;
           if($obsolete eq 'Y'){$assay_type = 'Obsoleted VA'}
           else{$assay_type = 'Valid VA'}

           $vic_sim = 'Y' if $vic_seq eq $assay{ProbeSeq1};
           $fam_sim = 'Y' if $fam_seq eq $assay{ProbeSeq2};
           $fwd_sim = 'Y' if $fwd_seq eq $assay{ForSeq};
           $rev_sim = 'Y' if $rev_seq eq $assay{RevSeq};

           if($vic_sim eq 'Y' and $fam_sim eq 'Y' and $fwd_sim eq 'Y' and $rev_sim eq 'Y'){
              $all_sim = 'Y';
              $oldsame{$assay{UID}} = 1;
           }

           $comp_out .= "$assay_name\t$vic_seq\t$vic_tm\t$fam_seq\t$fam_tm\t$fwd_seq\t$fwd_tm\t$rev_seq\t$rev_tm\t$assay_type\t$all_sim\t$vic_sim\t$fam_sim\t$fwd_sim\t$rev_sim\t$amp_seq\t$amp_len\t$obsolete\t$obs_note\n";
           $exist_assay++;
        }


        # compare with existing Aod/DME/cSNP assays
        $sth_adc->execute($cv_number) or die $dbh->errstr;
        while(my($assay_name,$vic_seq,$vic_tm,$fam_seq,$fam_tm,$fwd_seq,$fwd_tm,$rev_seq,$rev_tm,$amp_seq,$amp_len)=$sth_adc->fetchrow_array){
           my($vic_sim,$fam_sim,$fwd_sim,$rev_sim,$all_sim)=('N','N','N','N','N');
           
           $vic_tm = '-' unless $vic_tm;
           $fam_tm = '-' unless $fam_tm;
           $fwd_tm = '-' unless $fwd_tm;
           $rev_tm = '-' unless $rev_tm;
           unless($amp_seq){ $amp_seq = '-'; $amp_len = '-' }

           if($amp_len eq '-1' and length($amp_seq) > 1){ $amp_len = length($amp_seq); }

           # Get the assay type and obsolescence information
           my ($assay_type, $obsolete, $obs_note);
           my $valid_adc = 0;
           $sth_adc_prod->execute($assay_name) or die $dbh->errstr;

           while(($obsolete,$obs_note) = $sth_adc_prod->fetchrow_array){
             if($obsolete eq 'Y'){
               $assay_type = 'Obsoleted non-VA'; 
               $obs_note = '-' unless $obs_note;
               $obs_note =~ s/^\s*\;\s*//g;
             } else { $valid_adc++; }
           }
         
           if($valid_adc){ $assay_type = 'Valid non-VA'; $obs_note = '-'; $obsolete = 'N' }

           # assays that are not in T_ECOMMERCE_ALL_ENTRY
           unless($obsolete){$assay_type = 'non-VA'; $obsolete = 'N/A'; $obs_note = '-'; }

           $vic_sim = 'Y' if $vic_seq eq $assay{ProbeSeq1};
           $fam_sim = 'Y' if $fam_seq eq $assay{ProbeSeq2};
           $fwd_sim = 'Y' if $fwd_seq eq $assay{ForSeq};
           $rev_sim = 'Y' if $rev_seq eq $assay{RevSeq};

           if($vic_sim eq 'Y' and $fam_sim eq 'Y' and $fwd_sim eq 'Y' and $rev_sim eq 'Y'){
              $all_sim = 'Y';
              $oldsame{$assay{UID}} = 1;
           }

           $comp_out .= "$assay_name\t$vic_seq\t$vic_tm\t$fam_seq\t$fam_tm\t$fwd_seq\t$fwd_tm\t$rev_seq\t$rev_tm\t$assay_type\t$all_sim\t$vic_sim\t$fam_sim\t$fwd_sim\t$rev_sim\t$amp_seq\t$amp_len\t$obsolete\t$obs_note\n";
           $exist_assay++;
        }

        # print a blank line between each new assay
        if($exist_assay){print OUT "$comp_out\n";}

        unless($oldsame{$assay{UID}}){ print MODFILE $fline }
     } # End of <FILE> loop


     close MODFILE;
   } # End of $type loop

   close OUT;
   return 1;
} # end of compareDesign subroutine

__END__
