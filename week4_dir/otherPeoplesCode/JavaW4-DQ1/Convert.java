//UoL CKIT510 
//Delisa SImonovic 
//July 2013 
//W4 - DQ1 
import javax.swing.*; 
import java.text.*;
  
//Create a class that will contain needed methods and dialog objects  
  
public class Convert 
{
	public double sterlingGB;
   public String dollarUS;
	public DecimalFormat df = new DecimalFormat("#.##");
	//Method for input validation 			
	
	public boolean isNumeric(String str)
	{
		 NumberFormat formatter = NumberFormat.getInstance();
		 ParsePosition pos = new ParsePosition(0);
		 formatter.parse(str, pos);
		 return str.length() == pos.getIndex();
	}
	//Method for displaying results with option to continue another cycle or to quit
	public void resultMsg()
	{
	SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                int selection = JOptionPane.showConfirmDialog(
                                null
								, dollarUS+" dollars is " +df.format(sterlingGB)+" pounds. Press cancel to exit application."
                        , "Result"
                        , JOptionPane.OK_CANCEL_OPTION
                        , JOptionPane.INFORMATION_MESSAGE);
                      
                if (selection == JOptionPane.OK_OPTION)
                {
                    // If ok is pressed then run
                   getAmount() ;
                }
                else if (selection == JOptionPane.CANCEL_OPTION)
                {
                    // If cancel is pressed then exit application
                    System.exit(0);
                }
            }           
        });

	}
	
	
	public void getAmount()  
	{    
		//Prompt user for input		
		dollarUS=JOptionPane.showInputDialog(null,
											"Enter amount of Sterling pounds to be converted." ,
											"Amount!",
											JOptionPane.QUESTION_MESSAGE);	
		

		 	try	  	
		      {
				   //Validation if input is numeric
					if (isNumeric(dollarUS))
					{
						 sterlingGB=Double.parseDouble(dollarUS) * 0.5236;
						 resultMsg();
						 
			      }	
					
				   else
				   {
					JOptionPane.showConfirmDialog(null, "Please enter numerical value!",
															"Warning!",
															JOptionPane.WARNING_MESSAGE);
					//If input is not numeric then call getDistance method again										
					getAmount();
				   }
		     }
			 //Empty string validation if nothing is entered
			 catch(NumberFormatException e )
			 	{
				JOptionPane.showMessageDialog(null, 			
					                     		" You entered no value!", 
					                      		"Result", 
					                      		JOptionPane.INFORMATION_MESSAGE);
	   
		getAmount();
		}
	
 }
}