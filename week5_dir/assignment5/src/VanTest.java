
public class VanTest {
	
	public static void main(String[] args) {
		int day = 25;
		int month = 2;
		int year = 1972;
		Van myVan = new Van("Ford", "E-150", day, month, year, 3500);
	
		float tax = myVan.getTax();
		String date = myVan.getRegistrationDateDDMMMMYYYY();
		//System.out.println(date);
		System.out.println(myVan.toString());
	}

}
