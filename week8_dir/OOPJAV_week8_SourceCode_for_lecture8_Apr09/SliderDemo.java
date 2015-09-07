/* OHE campus, Dr. Yanguo Jing, 3rd September 2007, A JSlider example */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class SliderDemo extends JPanel implements ChangeListener {
    //Set up animation parameters.
    static final int FPS_MIN = 0;
    static final int FPS_MAX = 30;
    static final int FPS_INIT = 15;    //initial frames per second
    JLabel numberLabel;
    public SliderDemo() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //Create the label.
        JLabel sliderLabel = new JLabel("Slide control the number", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Create the slider.
        JSlider slider= new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
        slider.addChangeListener(this);
        //Turn on labels at major tick marks.
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        slider.setFont(font);
        //Create the label that displays the number.
        numberLabel = new JLabel();
        numberLabel.setHorizontalAlignment(JLabel.CENTER);
        numberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numberLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        updateNumber((int)slider.getValue());
        //Put everything together.
        add(sliderLabel);
        add(slider);
        add(numberLabel);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }
    /** Listen to the slider. */
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            updateNumber((int)source.getValue());
            }
    }
    // Update the Number diaplying in the label
    protected void updateNumber(int frameNum) {
        //Get the number
         numberLabel.setText(frameNum+"");
    }
    // Create the GUI and show it. For thread safety, this method
    // should be invoked from the event-dispatching thread.
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SliderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SliderDemo demo1 = new SliderDemo();
        //Add content to the window.
        frame.add(demo1, BorderLayout.CENTER);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
    /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
    //Schedule a job for the event-dispatching thread, creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}