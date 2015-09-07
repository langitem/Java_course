//UoL CKIT510 
//Delisa SImonovic 
//July 2013 
//W3 - DQ1 
import javax.swing.*; 
import java.text.*;
  
//Create a class that will contain needed methods and dialog object  
  
public class Compare 
{
	public static String double1;
   public static String double2;
	Object[] onlyOkButton = {"OK"};
	
	//Method for input validation 			
	
	public static boolean isNumeric(String str)
	{
		 NumberFormat formatter = NumberFormat.getInstance();
		 ParsePosition pos = new ParsePosition(0);
		 formatter.parse(str, pos);
		 return str.length() == pos.getIndex();
	}
	
	public void greaterThan()  
	{    
		//Catch user input    
	 
	   //Define input fields
		JTextField txtDouble1 = new JTextField("", 5);
		JTextField txtDouble2 = new JTextField("", 5);
		JLabel label1 = new JLabel();     
	   JPanel myPanel = new JPanel();
		label1.setText("Enter values:");
		label1.setBounds(0,0,100,50);
				myPanel.add(label1);
		      myPanel.add(new JLabel("Double1"));
            myPanel.add(txtDouble1);
            myPanel.add(new JLabel("Double2"));
            myPanel.add(txtDouble2);	
		//Prompt user for input		
		JOptionPane.showOptionDialog(null,
											myPanel,
											"Input two vales of type double to be compared",
											JOptionPane.INFORMATION_MESSAGE,
										   JOptionPane.OK_CANCEL_OPTION,
										   null,
										   onlyOkButton,
										   onlyOkButton[0]);

					
		
		
		
		//Input values are passed to variables 
		double1 = txtDouble1.getText();
		double2 = txtDouble2.getText();
	 
		
 	try	  	
      {
		   //Validation if input is numeric
			if (isNumeric(double1) && isNumeric(double2))
			{
			   //Input comparison
				if (Double.parseDouble(double1) > Double.parseDouble(double2))
				{
					JOptionPane.showMessageDialog(null, 			
			                     		double1+ " is bigger than " +double2, 
			                      		"Result", 
			                      		JOptionPane.INFORMATION_MESSAGE);
				}
		   	else if (Double.parseDouble(double1) < Double.parseDouble(double2))
				{
					JOptionPane.showMessageDialog(null, 			
			                     		double2+ " is bigger than "+double1 , 
			                      		"Result", 
			                      		JOptionPane.INFORMATION_MESSAGE);
				} 
				else if (Double.parseDouble(double1) == Double.parseDouble(double2))
				{	 
					JOptionPane.showMessageDialog(null, 			
			                     		" You entered two equal values!", 
			                      		"Result", 
			                      		JOptionPane.INFORMATION_MESSAGE);					
				}
	      }	
			
		   else
		   {
			JOptionPane.showConfirmDialog(null, "Please enter numerical value!",
													"Warning!",
													JOptionPane.WARNING_MESSAGE);
			//If input is not numeric then call getDistance method again										
			greaterThan();
		   }
     }
	 //Empty string validation if nothing is entered
	 catch(NumberFormatException e )
	 	{
		JOptionPane.showMessageDialog(null, 			
			                     		" You entered no value!", 
			                      		"Result", 
			                      		JOptionPane.INFORMATION_MESSAGE);
	   
		greaterThan();
		}
	
 }
}