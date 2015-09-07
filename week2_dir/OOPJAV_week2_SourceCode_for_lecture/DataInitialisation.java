//DATA INITIALISATION CLASS
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class DataInitialisation{

	//-------ATTRIBUTES-------
	private int dataItem1 = 0;
	private int dataItem2 = 1, dataItem3 = 2;
	private int dataItem4 = dataItem3 + 1;
	private int dataItem5 = dataItem2 + dataItem4;

	//-------METHODS-------

	/*-------OUTPUT DATA-------*/
	/*Method to output values associated with instance fields.*/

	public void outputData(){
		JOptionPane.showMessageDialog(null, "Item 1 = " + dataItem1);
        		JOptionPane.showMessageDialog(null, "Item 2 = " + dataItem2);
        		JOptionPane.showMessageDialog(null, "Item 3 = " + dataItem3);
        		JOptionPane.showMessageDialog(null, "Item 4 = " + dataItem4);
        		JOptionPane.showMessageDialog(null, "Item 5 = " + dataItem5);
        	}

        	/*-------NEW VALUES-------*/
        	/*Method to assign new values to the instance fields*/

        	public void newValues(int value1, int value2, int value3, int value4, int value5){
            	dataItem1 = value1;
            	dataItem2 = value2;
            	dataItem3 = value3;
            	dataItem4 = value4;
            	dataItem5 = value5;
        	}
}
