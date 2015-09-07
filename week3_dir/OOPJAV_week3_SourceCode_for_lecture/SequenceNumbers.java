//SEQUENCE NUMBERS CLASS
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class SequenceNumbers{

	//-------Main Method-------

	public static void main(String[ ] args){
		int loopParam;
		final int startCondition = 0;
		final int endCondition = 10;

		//For loop
		for (loopParam = startCondition; loopParam < endCondition; loopParam++){
			JOptionPane.showMessageDialog(null, loopParam + "");
		}
	}
}
