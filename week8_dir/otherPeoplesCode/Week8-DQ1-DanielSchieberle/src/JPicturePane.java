// SchieberleWeek8HI.java
// Class implementing a picture panel allowing to bring a picture to the front based on an index
// Author: Daniel Schieberle
// Last Update: August 23rd 2013


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


// class declaration
public class JPicturePane extends JPanel {
	
	private final static Dimension PREFERRED_DIMENSION = new Dimension(320,240);
	
	private JPanel picturePanel;
	private JPanel progressPanel;	
	private int currentIndex = -1;
	private int panelCount = 0;
	private JProgressBar progress;
	private ArrayList<ActionListener> actionListenerList;	

	// constructor
	public JPicturePane() {
		super();
		// card layout allows fliping of panels
		setLayout(new CardLayout());
		setPreferredSize(PREFERRED_DIMENSION);
		
		// add panel holding a progressbar
		progressPanel = new JPanel();
		progressPanel.setPreferredSize(PREFERRED_DIMENSION);
		add(progressPanel,"PREVIEW");
		
		progress = new JProgressBar(0,100);
		progressPanel.add(progress);
	
		// add the picture panel having cardlayout as well
		picturePanel = new JPanel( new CardLayout());
		add(picturePanel,"PICTURES");										
	} // end of constructor
	
	// method to update the progressbar based on a percentage value
	public void showProgress(int percentage) {
		progress.setValue(percentage);
	} // end of method showProgress
	
	// method to bring one of the main panels (PREVIEW or PICTURE) to the front
	public void bringToView(String identifier) {
		CardLayout cl = (CardLayout)(getLayout());
        cl.show(this, identifier);			
	} // end of method bringToView
	
	// method to finish up after external loading and to notify listeners
	public void done() {
		currentIndex=0;
		bringToView("PICTURES");
		showImage(0);
		notifyListeners(new ActionEvent(this,ActionEvent.ACTION_PERFORMED ,"READY"));
	} // end of method done
	
	// method to add a picture to the picturepanel
	public synchronized void addImage(int index, BufferedImage image) {
		JPanel imagePanel = new JPanel();
		imagePanel.setPreferredSize(PREFERRED_DIMENSION);
		imagePanel.add(new JLabel(new ImageIcon(image)));
		picturePanel.add(imagePanel,"IMAGE"+index);
		panelCount++;
	} // end of method addImage
	
	// method to bring one of the images to the front
	public void showImage(int index) {
		if (index != currentIndex) {
			CardLayout cl = (CardLayout)(picturePanel.getLayout());
			cl.show(picturePanel, "IMAGE"+index);
			currentIndex = index;
		}
	} // end of method showImage

	
	// helper method to register a listener 
	// since Swing is not thread-safe, method needs to be "synchronized"
    public synchronized void addActionListener(ActionListener listener) {
    	// create ArrayList if empty
    	if(actionListenerList == null) {  
    	     actionListenerList = new ArrayList<ActionListener>();  
	    }  
    	// only add if listener is not already registered
	    if(!actionListenerList.contains(listener)) {  
	             actionListenerList.add(listener);  
	    }  
	} // end of method addActionListener
    
	// helper method to unregister a listener 
    public synchronized void removeActionListener(ActionListener listener) {  
        if(actionListenerList != null && actionListenerList.contains(listener)) {  
    	     actionListenerList.remove(listener);  
	    }  
	}  // end of method removeActionListener

	// helper method to notify listeners    
	private void notifyListeners(ActionEvent e) {  
	    ArrayList<ActionListener> list;
	    // since swing is not thread safe, get a synchronized copy of the listeners first.
	    synchronized(this) {  
	             if(actionListenerList == null) return;  
	             list = new ArrayList<ActionListener>(actionListenerList); 
	    }  
	    // work on the synchronized copy
	    // the method actionPerformed is mandatory for all objects 
	    for(int i = 0; i < list.size(); i++) {  
	             ActionListener listener = (ActionListener)list.get(i);  
	             listener.actionPerformed(e);  
	     }  
	} // end of method notifyListeners	

	public int getPanelCount() {
		return panelCount;
	}

	public void setPanelCount(int panelCount) {
		this.panelCount = panelCount;
	}
	
} // end of class
