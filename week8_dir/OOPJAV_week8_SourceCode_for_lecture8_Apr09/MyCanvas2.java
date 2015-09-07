//Applet Example 4 - MyCanvus2
//Kimberly Watson
//Thursday 10 June 2004
//The University of Liverpool, UK

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class MyCanvas2 extends Canvas {


 /* Fonts */

    //Graphics g;
    Font mono = new Font("monospaced",Font.BOLD,20);

    public void paint(Graphics g) {
        String s1;

        // Rectangles

        g.setColor(Color.black);
        g.setFont(mono);
        g.drawRect( 25, 25, 70, 30);
        g.drawRect(165, 25, 70, 30);
        g.drawRect(305, 25, 70, 30);

        // Output
        outputString(g,Integer.toString(AppletEx4.dataItem1),
                                                  60,48);
        outputString(g,"+",130,48);
        outputString(g,Integer.toString(AppletEx4.dataItem2),
                                                  200,48);
        outputString(g,"=",270,48);
        int total = AppletEx4.dataItem1 + AppletEx4.dataItem2;
        outputString(g,Integer.toString(total),340,48);
        }

    private void outputString(Graphics g,String s1,int 	xCoord, int yCoord) {

        // Font metric

        FontMetrics newFM = g.getFontMetrics(mono);

        // Output

        int xLength = newFM.stringWidth(s1);
        g.drawString(s1,(xCoord-(xLength/2)),yCoord);
	  }
    }
