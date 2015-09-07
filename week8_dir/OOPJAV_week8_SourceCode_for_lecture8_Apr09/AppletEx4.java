//Applet Example 4
//Kimberly Watson
//Thursday 10 June 2004
//The University of Liverpool, UK

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class AppletEx4 extends Applet implements ActionListener {

    MyCanvas2 pic = new MyCanvas2();

    TextField input1 = new TextField(10);
    TextField input2 = new TextField(10);
    TextField output = new TextField(10);

    Button pushButton = new Button("START");

    private final int WIDTH  = 100;
    private final int HEIGHT = 30;
    public static int dataItem1    = 0;
    public static int dataItem2    = 0;

    public void init() {
        setBackground(Color.yellow);
        setLayout(null);

        addTextField(input1,100,50);
        addTextField(input2,300,50);
        output.setEditable(false);

        // Add push button
	
        addPushButton(pushButton,200,100);

        // Add push Canvas
	          
        addCanvas(pic,400,80,50,170);
        }

    private void addTextField(TextField name, int xCoord,
                                                    int yCoord) {
        name.setBackground(Color.red);
	  name.setForeground(Color.black);
	  name.setLocation(xCoord,yCoord);
	  name.setSize(WIDTH,HEIGHT);
	  add(name);
	  name.addActionListener(this);
        }
	
    /* Add push button */

    private void addPushButton(Button name, int xCoord,
                                                    int yCoord) {
        name.setBackground(Color.red);
	  name.setForeground(Color.black);
	  name.setLocation(xCoord,yCoord);
	  name.setSize(WIDTH,HEIGHT);
	  add(name);
	  name.addActionListener(this);
        }

    /* Add canvas */

    private void addCanvas(MyCanvas2 name, int width,
                           int height, int xCoord, int yCoord) {
        name.setBackground(Color.white);
	  name.setLocation(xCoord,yCoord);
	  name.setSize(width,height);
	  add(name);
	  }

    /* Action Performed */

    public void actionPerformed(ActionEvent event) {

        // Get Action

        String data = event.getActionCommand();

        // Test for push Button or text field
	
        if (event.getSource() == pushButton)
                                   addCanvas(pic,400,80,50,170);
	  else if (event.getSource() == input1)
                   dataItem1 = (new Integer(data)).intValue();
        else dataItem2 = (new Integer(data)).intValue();
        }
    }
