import java.util.Vector;


public class VectorDemo{

    public static void main(String args[]){
	Vector v = new Vector();
	v.addElement(new USport("Dal", "Tigers"));
	v.addElement(new USport("SMU", "Huskies"));
	v.addElement(new USport("Acadia", "Axemen"));

	System.out.println(v); 
	//Uses Vector.toString() & USport.toString()

	for(int i = v.size() - 1; i >= 0; i--){
		USport us = (USport)v.elementAt(i);
		System.out.println(us.school);
	} 
    } 
}

//Note that values from a Vector are Objects
//You need to cast them to their original class (in this case USport)
