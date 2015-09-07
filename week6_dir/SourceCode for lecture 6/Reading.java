// Read File Applicaitons
// Dr. Y. Jing
// 10 December 2007
// The Unversity of Liverpool, UK

import java.io.*;

class Reading{
 public static void main (String[] args) throws IOException{
 	FileReader file = new FileReader("prices.txt");
 	BufferedReader inputFile = new BufferedReader(file);

 	String name;
 	float price=0.0f;

  while ((name = inputFile.readLine()) != null){
 		price = new Float(inputFile.readLine()).floatValue();
		System.out.println(price + "\t" + name);
		}
 	inputFile.close();
}
}