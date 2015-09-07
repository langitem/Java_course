import javax.swing.*;

public class kilometreConversion{

		double inputMetres;
                String metreEntry;
                double kiloMetres;

	public static void main(String[ ] args){
        kilometreConversion mykilometreConversion = new kilometreConversion();
        mykilometreConversion.GetMetres();
        mykilometreConversion.ConvertToKilometres();
        }

        public void GetMetres(){
		String metreEntry = JOptionPane.showInputDialog("Please enter the number of metres:");
                if(metreEntry.length() > 0) {
		inputMetres = new Double(metreEntry).doubleValue();
                }
                else
                inputMetres = 0;
                }

        public void ConvertToKilometres(){
                kiloMetres = inputMetres / 1000;
		JOptionPane.showMessageDialog(null, "When rounded up to the nearest kilometre, that is " + Math.round(kiloMetres) + "km.");
	}
}
