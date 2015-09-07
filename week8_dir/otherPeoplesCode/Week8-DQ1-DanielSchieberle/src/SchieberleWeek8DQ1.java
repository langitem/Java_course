// SchieberleWeek8HI.java
// Class to implement Week 8's HI logic
// Author: Daniel Schieberle
// Last Update: August 23rd 2013

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// class declaration
public class SchieberleWeek8DQ1 extends JFrame {
	
	private final static Border DEFAULT_BORDER = BorderFactory.createEmptyBorder(10,10,10,10);	
	private final static String APP_TITLE = "SliderDemo";
	
	// constant image resources
	private final static URL[] images = {	SchieberleWeek8DQ1.class.getResource("images/img01.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img02.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img03.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img04.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img05.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img06.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img07.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img08.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img09.jpg"),
											SchieberleWeek8DQ1.class.getResource("images/img10.jpg")};
	
	// Adjusted from Figure 8.1
	/* OHE campus, Dr. Yanguo Jing, 3rd September 2007, A JSlider example */	
    static final int FPS_MIN = 1;
    static final int FPS_MAX = 10;
    static final int FPS_INIT = 1;   
    // end of adjustment
        
	private JPicturePane picturePanel;
	private JSlider slider;
	
	
	// Constructor
	public SchieberleWeek8DQ1() {
		// setting Title
		super(APP_TITLE);
		
		// setting default close behavior
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setting up the GUI
		setupGUI();
		
		new BackgroundLoader(images, picturePanel).execute();
		
		pack();
		setLocationRelativeTo(null);
	} // end of Constructor
	
	// Private method to setup up the GUI
	private final void setupGUI() {		
		((JPanel) getContentPane()).setBorder(DEFAULT_BORDER);		

		addSlider();
		addPicturePanel();
	} // end of method setupGUI	
	
	
	private void addSlider() {
		
		// Adjusted from Figure 8.1
		/* OHE campus, Dr. Yanguo Jing, 3rd September 2007, A JSlider example */
        //Create the label.
        JLabel sliderLabel = new JLabel("Slide control the number", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Create the slider.
        slider= new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
        //slider.addChangeListener(this);
        //Turn on labels at all tick marks.
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        // slider will snap to the positions
        slider.setSnapToTicks(true);        
        
        slider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        slider.setFont(font);	
        
        // end of adjustment       
        // disable the slider for now
        slider.setEnabled(false);        
        slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// bring associated picture to front
					picturePanel.showImage(slider.getValue() - 1);
			}
        	
        });		
		add(slider,BorderLayout.NORTH);
	}
	
	// method to add a picture panel to the GUI
	private void addPicturePanel() {
		picturePanel = new JPicturePane();
		// 
		picturePanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					// finally enable the slider
					slider.setMaximum(picturePanel.getPanelCount());
					slider.setEnabled(true);
			}			
		});
		add(picturePanel,BorderLayout.CENTER);
		
		// add copyright note
		JLabel copyright = new JLabel("Pictures taken from www.bayern.by");
		add(copyright,BorderLayout.SOUTH);		
	} // end of method addPicturePanel 
		
} // end of class
