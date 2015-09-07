import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateClass {
	public static void main(String[] args ) throws ParseException {
		
		DateFormat formatter = null;
		Date convertedDate = null;
		
		int montInt = 2;
		int dayInt = 25;
		int yearInt = 1972;
		
		String ddMMyyyy = Integer.toString(dayInt) + "02" + Integer.toString(yearInt);
		
		//String ddMMyyyy = "25021972";
		formatter = new SimpleDateFormat("ddMMyyyy");
		convertedDate = (Date) formatter.parse(ddMMyyyy);
		
		System.out.println(convertedDate);
		
		//System.out.println(new SimpleDateFormat("MMMM").format(convertedDate));
		
		String month = new SimpleDateFormat("MMMM").format(convertedDate);
		System.out.println("month: " + month);
		
		String year = new SimpleDateFormat("yyyy").format(convertedDate);
		System.out.println("year:" + year);
		
		String day = new SimpleDateFormat("dd").format(convertedDate);
		System.out.println("day: " + day);
		
		String fullDate = new SimpleDateFormat("dd-MMMM-yyyy").format(convertedDate);
		System.out.println("Full date: " + fullDate);
	}
}
