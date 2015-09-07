import javax.swing.*;

/**
 * Created by myltik
 * Created on 7/21/13 9:47 PM
 */
public class W03DQ2App {

    private static final Object[] askViewButtons = new String[] {"Proceed", "Exit"};
    private MonthWrapper monthNumber = null;

    /**
     * Write and run a Java program which takes as input a month number and outputs the equivalent month name.
     * For example, if the input is 10 the output would be “October.”
     */
    public void run() {
        try {
            while (true) {
                askValues();
                displayResult();
            }
        } catch (CloseAppException e) {
            // do nothing, just exit app
        }
    }

    /**
     * Ask user to input month value (numeric)
     * @throws CloseAppException
     */
    private void askValues() throws CloseAppException {
        final MonthNumberInputPanel container = new MonthNumberInputPanel();
        monthNumber = null;

        // Validate input values, display error message if needed
        while (monthNumber == null) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    container,
                    "Specify Number Of Month",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    askViewButtons,
                    askViewButtons[0]
            );

            // Check whether cancel button has been clicked, exit app
            if (result == 1 || result == JOptionPane.CLOSED_OPTION) {
                throw new CloseAppException();
            }

            // Validate input values
            if (container.isValidValues()) {
                monthNumber = container.getValue();
            }
        }
    }

    /**
     * Display result, i.e. string representation of specified month
     */
    private void displayResult() {
        assert monthNumber != null;

        JOptionPane.showMessageDialog(
                null,
                "Name of month for specified value of " + monthNumber.getNumber() + " is " + monthNumber.getString(),
                "Name Of Month",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
