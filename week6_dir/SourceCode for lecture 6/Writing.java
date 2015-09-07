// Write into File Applicaitons
// Dr. Y. Jing
// 10 December 2007
// The Unversity of Liverpool, UK

import java.io.*;

class Writing
{
public static void main (String[] args) throws IOException
{
  final float poundsToAdd=2.0f;

  FileReader file1 = new FileReader("prices.txt");
  BufferedReader inputFile = new BufferedReader(file1);

  FileWriter file2 = new FileWriter("newPrices.txt");
  PrintWriter outputFile = new PrintWriter(file2);

  String name;
  float price=0;


  while ((name=inputFile.readLine()) != null)
  {
   price = new Float(inputFile.readLine()).floatValue();
   price=price+poundsToAdd;
   outputFile.println(price+"\t"+name);
  }
  inputFile.close();
  outputFile.close();

}

}