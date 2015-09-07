//FOR LOOP EXAMPLE APPLICATION
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class ForLoopsExampleApp{

	//-------Main Method-------

	public static void main(String[ ] args){
		int loopCounter, total = 0, increment;

		//Normal for loop to determine total
		for(loopCounter = 1; loopCounter < 10; loopCounter++){
			total = total + loopCounter;
		}
		JOptionPane.showMessageDialog(null, "Loop 1 Total =" + total);

		//No loop counter initialisation expression
		for(; total > 10; total = total - 5){
			JOptionPane.showMessageDialog(null, "Loop 2 Total =" + total);
		}

		//No exit condition expression (variable count loop)
		for (loopCounter = 1;  ; loopCounter++){
			total = total + loopCounter;
			JOptionPane.showMessageDialog(null, "Loop 3 Total =" + total);
			if(total > 50) break;
		}

		//Internal manual increment
		increment = 1;
		for(total = 0; total < 50; ){
			total = total + increment;
			increment = increment + 2;
		}
		JOptionPane.showMessageDialog(null, "Loop 4 Total =" + total);
	}
}
