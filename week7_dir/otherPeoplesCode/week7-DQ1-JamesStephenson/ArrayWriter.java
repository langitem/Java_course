import java.lang.Runnable;

public class ArrayWriter implements Runnable
{
   private final SimpleArray sharedSimpleArray;
   private final char startValue;//change from int to char

   public ArrayWriter(char value, SimpleArray array) {//change first parameter from int to char
      startValue = value;
      sharedSimpleArray= array;
   }

   public void run() {
      for (int i = (int)startValue; i < (int)startValue + 3; i++) { //cast startValue into int        
         sharedSimpleArray.add((char)i);//cast i into a char 
      } 
   } 
}