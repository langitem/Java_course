/**
 * Created by myltik
 * Created on 7/21/13 9:24 PM
 */
public class MonthWrapper {

    protected final int number;
    protected final String string;

    public MonthWrapper(int number) throws NumberFormatException{
        this.string = getNameByNumber(number);
        this.number = number;
    }

    protected String getNameByNumber(int number) throws NumberFormatException{
        switch (number) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }

        throw new NumberFormatException("Month's number should be between 1 and 12 values inclusive");
    }

    public String getString() {
        return string;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "MonthWrapper{" +
                "number=" + number +
                ", string='" + string + '\'' +
                '}';
    }
}
