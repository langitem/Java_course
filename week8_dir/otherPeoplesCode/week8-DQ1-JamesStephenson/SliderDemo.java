/* OHE campus, Dr. Yanguo Jing, 3rd September 2007, A JSlider example */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//NEW
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.activation.MimetypesFileTypeMap;

public class SliderDemo extends JPanel implements ChangeListener {
    //Set up animation parameters.
    static final int FPS_MIN = 1;
    static final int FPS_MAX = 10;//chnage to 10
    static final int FPS_INIT = 5;//change to 5    
    private BufferedImage[] images = new BufferedImage[FPS_MAX];//stores the images
    private JLabel imageLabel;//replaces the numberLabel

    public SliderDemo() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel sliderLabel = new JLabel("Slide control the number", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider slider= new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
        slider.addChangeListener(this);
        slider.setMajorTickSpacing(1);//change to 1
        slider.setMinorTickSpacing(1);//change to 1
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        slider.setFont(font);
        imageLabel = new JLabel();//replaces numberLabel
        loadImages();//call to a new method
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        updateImage(FPS_INIT);//replaces call to updateNumber method
        addComponents(sliderLabel,slider,imageLabel);//replaces 3 calls to add method.
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    public void addComponents(JLabel aSliderLabel, JSlider aSlider, JLabel anImageLabel) {//refactored method
         add(aSliderLabel);
         add(aSlider);
         add(anImageLabel);
    } 

    public void loadImages() {//new method to load files
        File folder = new File("images/");
        File[] listOfFiles = folder.listFiles();
        int counter = 0;
        for (File file : listOfFiles) {
            String mimetype= new MimetypesFileTypeMap().getContentType(file);
            String type = mimetype.split("/")[0];
            if (file.isFile() && type.equals("image")) {
                try {
                    images[counter] = ImageIO.read(file);
                    counter++;
                 } catch (IOException ex) {
                    //
                 }  
            }
        }
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            updateImage((int)source.getValue());//replace the call to the updateNumber method
        }
    }
    
    // Replaces the updateNumber method
    protected void updateImage(int imageNum) {
        ImageIcon icon = new ImageIcon(images[imageNum-1]);
        if(icon != null) {
            imageLabel.setIcon(icon);
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SliderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SliderDemo demo1 = new SliderDemo();
        frame.add(demo1, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}