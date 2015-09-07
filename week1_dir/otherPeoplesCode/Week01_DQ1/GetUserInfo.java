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
public class GetUserInfo
{
   // Display input dialog to user to enter his/her name
    public String GetUserName()
    {
            String TempString = "";
            while (TempString == "" || TempString.trim().length() <= 0 )
            {
                TempString = JOptionPane.showInputDialog(null, "What is your Name?", "Enter Your Name", JOptionPane.QUESTION_MESSAGE);
            }
             return TempString;
        }

    public Date GetUserBirthDate()
    {
        String TempString = "";
        try
        {
            while (!Checkdate(TempString))
            {
                TempString =  JOptionPane.showInputDialog(null,"What is your Birthdate ?          YYYY-MM-DD","Enter Your BirthDate", JOptionPane.QUESTION_MESSAGE);
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return  df.parse(TempString);
        } catch (ParseException e) {
            return null;
        }

    }

    private static boolean Checkdate(String UserString)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date TempDate = df.parse(UserString);
            return true ;
        }
        catch(ParseException e)
        {
            return false;
        }

    }
}
