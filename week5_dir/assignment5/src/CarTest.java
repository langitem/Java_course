
public class CarTest {
	public static void main(String[] args) {
		String manufacturer = "BMW";
		String model = "335i";
		int day = 2;
		int month = 3;
		int year = 2001;
		int engineSize = 1551;
		int emission = 190;
		
		Car myCar = new Car(manufacturer, model, day, month, year, engineSize, emission);
		
		float tax = myCar.getTax();
		// System.out.println(tax);
		System.out.println(myCar.toString());
	}

}