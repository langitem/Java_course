import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**

 * Student ID	: H00025069
 * Created by	: Mohamed Samir
 * Module		: Object Oriented Programming in Java (OOPJAV)
 * Task			: Week 1 DQ 1
 * Date: 7/6/13
 * Time: 4:03 PM

 **/


public class MainClass
{
  public static void main (String[] arg)
  {
      // define local variable
      String UserName;
      Date  UserBirthDate;

      // Display Greeting to user
      DisplayGreeting();

      // define instance from GetUserinfo Class
      GetUserInfo TempUser = new GetUserInfo();

      // Access class methods
      UserName = TempUser.GetUserName();
      UserBirthDate = TempUser.GetUserBirthDate();

      // display user information beck to the user
      DisplayUserInfo(UserName,UserBirthDate);
  }
    private static void DisplayGreeting()
    {
        JOptionPane.showMessageDialog(null,"\nWelCome to My First Program with Java!\n\n by Mohamed Samir","WelCome",JOptionPane.INFORMATION_MESSAGE);
    }
    private static void DisplayUserInfo(String TempUserName, Date TempUserBirthDate)
    {
        JOptionPane.showMessageDialog(null,TempUserName + "\n\n" + TempUserBirthDate.toString() + "\n\n Thank you using my first Java Program", "User Information",JOptionPane.INFORMATION_MESSAGE);
    }

}
