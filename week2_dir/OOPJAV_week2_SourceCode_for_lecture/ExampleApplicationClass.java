//EXAMPLE APPLICATION CLASS
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class ExampleApplicationClass{

	//-------FIELDS-------
	private int value;

	//-------Main Method-------
	public static void main(String [ ] args){
		ExampleClass instance1 = new ExampleClass(2);
		ExampleClass instance2 = new ExampleClass(3);

		//Output
		JOptionPane.showMessageDialog(null, "Instance 1 = " + instance1.treble());
		JOptionPane.showMessageDialog(null, "Instance 2 = " + instance2.treble());
	}
}
