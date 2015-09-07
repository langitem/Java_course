//SMILEY FACE APPLICATION
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class SmileyFace{

	//-------Main Method-------

	public static void main(String[ ] args){
		int loopParameter;
		final int startCondition = 0;
		final int endCondition = 10;		

		//For loop
		for (loopParameter = startCondition; loopParameter < endCondition; loopParameter++){
			JOptionPane.showMessageDialog(null, ":-D");
		}
	}
}
