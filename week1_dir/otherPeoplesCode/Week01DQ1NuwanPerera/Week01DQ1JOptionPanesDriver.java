//Week 01 DQ1: Your first Java application
//Nuwan Perera
//07th July, 2013
//The University of Liverpool, UK

public class Week01DQ1JOptionPanesDriver {
    public static void main(String[] args) {
		Week01DQ1JOptionPanes objJOptionPanes = new Week01DQ1JOptionPanes();
		//1.First, display a welcome message to your user in one JOptionPane when the application starts.
        objJOptionPanes.showWelcomeMsg();
		//2.Second, when the user closes the first JOptionPane, use another one to ask the user for his or her name.
		objJOptionPanes.requestUserName();
		//3.Third, use another JOptionPane to ask the user for his or her birth date.
		objJOptionPanes.requestBirthday();
		//4.Finally, use a fourth JOptionPane to display the user’s name and birth date and thank them for using your program.
		objJOptionPanes.showFinalMsg();
    }
}