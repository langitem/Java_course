//MENU INTERFACE EXAMPLE APPLICATION
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class MenuInterfaceExApp{

	//-------Main Method-------

	public static void main(String[ ] args) {
		int selector;
		selector = outputMenu();
		processSelector(selector);
	}

	public static int outputMenu(){
		String input = JOptionPane.showInputDialog("Please select a number representing a programming paradigm:  1 - Imperative, 2 - Object-oriented, 3 - Logical, 4 - Functional, 5 - Parallel.");
		return(new Integer(input).intValue());
	}

	public static void processSelector(int selector) {
		switch(selector){
			case 1:
				JOptionPane.showMessageDialog(null, "Example languages include C, Ada and Pascal.");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Example languages include Java, Eiffel and C++.");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Example languages include Prolog.");
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Example languages include Lisp and Miranda.");
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Example languages include high performance Fortran.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Unrecognized menu selection " + selector + "!");
				selector = outputMenu();
				processSelector(selector);
		}
	}
}
