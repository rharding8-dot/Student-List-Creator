import java.util.Scanner;

public class Date {
    private int month;
    private int day;
    private int year;

    public static Scanner input = new Scanner(System.in);

    public Date(int month, int day, int year) {
        setYear(year);
        setMonth(month);
        setDay(day); 
    }//end Date constructor with fields

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }//end is leapYear (checks for leap year)

    public int getYear() {
        return year;
    }//end get year

    public void setYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be positive.");
        }//exception handling
        this.year = year;
    }//end set year

    public int getMonth() {
        return month;
    }//end get month

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }//exception handling
        this.month = month;
    }//end set month

    public int getDay() {
        return day;
    }//end get day
    
    public void setDay(int day) {
        if (day < 1) {
            throw new IllegalArgumentException("Day must be at least 1.");
        }//exception handling
        if ((month == 2 && ((isLeapYear(year) && day > 29) || (!isLeapYear(year) && day > 28))) ||
            ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) ||
            (day > 31)) {
            throw new IllegalArgumentException("Invalid day for the given month and year.");
        }//exception handling
        this.day = day;
    }//end set Day

     public String toString() {
            return month + "/" + day + "/" + year;
        }//end toString method

}//end Date class