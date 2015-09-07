import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Month's number input container.
 */
public class MonthNumberInputPanel extends JPanel {

    protected final JLabel statusLabel;
    protected final JTextField valueField;

    public MonthNumberInputPanel() {
        super(new BorderLayout());

        //
        // Information message

        this.add(new JLabel("Please input a number representing a month (1-12)"), BorderLayout.NORTH);


        //
        // Input fields

        final Border inputNameBorder = BorderFactory.createEmptyBorder(5, 0, 5, 0);

        final JLabel widthLabel = new JLabel("Number of month:");
        widthLabel.setBorder(inputNameBorder);

        final JPanel inputNamesContainer = new JPanel();
        inputNamesContainer.setLayout(new BoxLayout(inputNamesContainer, BoxLayout.Y_AXIS));
        inputNamesContainer.add(widthLabel);

        JPanel inputFieldsContainer = new JPanel();
        inputFieldsContainer.setLayout(new BoxLayout(inputFieldsContainer, BoxLayout.Y_AXIS));
        valueField = new JTextField(15);
        inputFieldsContainer.add(valueField);

        final JPanel inputContainer = new JPanel(new FlowLayout());
        inputContainer.add(inputNamesContainer);
        inputContainer.add(inputFieldsContainer);

        this.add(inputContainer, BorderLayout.WEST);


        //
        // Status label to display error message if needed

        statusLabel = new JLabel("");
        statusLabel.setForeground(Color.RED);
        this.add(statusLabel, BorderLayout.SOUTH);
    }

    /**
     * Validate all input fields, display error in case of invalid value(s)
     * @return true if all values are valid, false otherwise
     */
    public boolean isValidValues() {
        try {
            getValue();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid value, should be a number between 1 and 12 inclusive");
            return false;
        }

        return true;
    }

    /**
     * @return Month's number
     */
    public MonthWrapper getValue() {
        return new MonthWrapper(getIntInputValue(valueField));
    }

    /**
     * @param inputField Input field holding the value
     * @return Integer value parsed from specified input field
     */
    private int getIntInputValue(JTextField inputField) {
        return Integer.valueOf(inputField.getText()).intValue();
    }
}
