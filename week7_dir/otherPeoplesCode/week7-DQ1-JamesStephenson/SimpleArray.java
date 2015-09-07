import java.util.Arrays;
import java.util.Random;

public class SimpleArray
{
   private final char array[];//change from int to char array
   private int writeIndex = 0; 
   private final static Random generator = new Random();

   public SimpleArray(int size) {
      array = new char[size];//change from int to char array
   } 

   public synchronized void add(char value) { //change parameter from int to char 
      int position = writeIndex; 
      try {
         Thread.sleep(generator.nextInt(500)); 
      } catch (InterruptedException ex) {
         ex.printStackTrace();
      } 
      array[position] = value;
      System.out.printf( "%s wrote %c to element %d.\n", 
         Thread.currentThread().getName(), value, position ); //change %2d to %c
      ++writeIndex; 
      System.out.printf( "Next write index: %d\n", writeIndex );
   } 

   public String toString() {
      return "\nContents of SimpleArray:\n" + Arrays.toString(array);
   } 
}