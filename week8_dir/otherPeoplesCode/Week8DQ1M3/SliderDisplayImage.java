//Week 8 DQ1 Assignment
//Designed by Fatai Oseni
//25th August 2013

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderDisplayImage extends JPanel implements ChangeListener
{
    //Set up Slider parameters.
    static final int SLD_MIN = 0;
    static final int SLD_MAX = 10;
    static final int SLD_INIT = 5;    //initial slider position
    private final static String[] images = {"Chrysanthemum.jpg","Desert.jpg","Hydrangeas.jpg","Jellyfish.jpg",
    										"Koala.jpg","Lighthouse.jpg","Penguins.jpg","Tulips.jpg","Eagle1.jpg","Eagle2.jpg"};
    JLabel imageLabel;
    JLabel sliderLabel;

    public SliderDisplayImage()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //Create the label.
        sliderLabel = new JLabel("Slide control the number", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Create the slider.
        JSlider slider= new JSlider(JSlider.HORIZONTAL, SLD_MIN, SLD_MAX, SLD_INIT);
        slider.addChangeListener(this);
        //Turn on labels at major tick marks.
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        slider.setFont(font);
        //Create the label that displays the image.
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        changeImage((int)slider.getValue());
        add(sliderLabel);
        add(slider);
        add(imageLabel);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }
    // slider listner
    public void stateChanged(ChangeEvent e)
    {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting())
        {
            changeImage((int)source.getValue());
        }
    }//end of stateChanged method

    // change the image diaplying in the label
    protected void changeImage(int frameNum)
    {
        // change the imade of the label using .setIcon property of JLabel
         if (frameNum > 0) {
			 imageLabel.setIcon( new ImageIcon(images[frameNum-1]));
			 sliderLabel.setText("Slide control the number: (" + frameNum + ") : Image Name -  " + images[frameNum-1]); //change the slider label
		 }
    }

}