    //Week 8 DQ1 Assignment
    //Designed by Fatai Oseni
    //25th August 2013

    //The application is to answer Week 08 DQ1: Picture Displaying
    /*
    DQ1: Try to develop a new application to use the example given in Figure 8-1 (in the lecture note),
	the new application should display one out of a possible 10 pictures in the window. Use should be able
	to choose the picture by position tick on the Slide bar.
    */
    import javax.swing.*;
    import java.awt.*;
    public class Week8DQ1Assignment
    {
	//main method begins program execution
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("SliderDisplayImage");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				SliderDisplayImage imageSlider = new SliderDisplayImage();
				frame.add(imageSlider, BorderLayout.CENTER);
				//Display the window.
				frame.pack();
				frame.setVisible(true);;
            }
        });
    }
 }