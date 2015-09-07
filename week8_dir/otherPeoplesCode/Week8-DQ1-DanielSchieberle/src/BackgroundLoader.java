// SchieberleWeek8HI.java
// Class loading images in a separate thread
// Author: Daniel Schieberle
// Last Update: August 23rd 2013

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

// class declaration extending SwingWorker
// SwingWorker itself extends the Thread class and takes care that GUI operations are done in the EDT.
public class BackgroundLoader extends SwingWorker<List<BufferedImage>, Integer> {
	
	private URL[] imageFiles;
	private JPicturePane picturePanel;

	// constructor
	public BackgroundLoader(URL[] imageFiles, JPicturePane picturePanel) {
		this.imageFiles = imageFiles;
		this.picturePanel = picturePanel;
	} // end of constructor
	
	// method invoked once the doInBackground makes progress
    protected void process(List<Integer> list) {
    	// update progress bar
		double progress = (list.get(0).doubleValue() / this.imageFiles.length) * 100;
		picturePanel.showProgress((int) Math.round(progress));
	} // end of method progress

	// method to perform tasks in the background
	protected List<BufferedImage> doInBackground() throws InterruptedException  {		
		if (imageFiles == null) {return null;}		
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		int index = 1;
		for (URL imageFile : imageFiles) {
			try {
				images.add(ImageIO.read(imageFile));
				publish(index);
				index++;	
				// just to make the progressbar update visible
            	Thread.sleep(100);				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return images;
	} // end of method doInBackground
	
    // method invoked once doInBackGround is done
    protected void done() {
        try {
        	int index = 0;
            for (BufferedImage image : get()) {
            	// add image to picture panel
            	picturePanel.addImage(index, image);
            	index++;
            }
            picturePanel.done();
          } catch (Exception e) { }
    } // end of method done	

} // end of class
