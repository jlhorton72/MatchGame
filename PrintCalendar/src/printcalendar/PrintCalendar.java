/*
 * Developer:       James Horton
 * Date:            01/22/2019
 * Project:         PrintCalender.java
 * Assignment:      13.4
 */
package printcalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Redindianfred
 */
public class PrintCalendar {
    /**
     * @param args the command line arguments
     */
        /** Main Method */
    public static void main(String[] args) 
    {
        int yy = getUserYear();
        int uMonth = getUserMonth();        
        int gregMonth = uMonth - 1;
               
        Calendar gregCal = new GregorianCalendar(yy, gregMonth, 1);
        // commented out 
//        System.out.println("Today: \t\t\t" + gregCal.get(Calendar.DAY_OF_MONTH));
//        System.out.println("Day of Week: \t\t" + gregCal.get(Calendar.DAY_OF_WEEK));
//        System.out.println("Month: \t\t\t" + gregCal.get(Calendar.MONTH));
//        System.out.println("Last Day of Month: \t" + gregCal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println("First Day of Month: \t" + gregCal.getMinimum(Calendar.DAY_OF_MONTH));
        int lastDay = gregCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        String mm = gregCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());     
               
        // Print calendar for the month of the year
        printMonth(yy, uMonth);
        System.out.println(mm + ", " + yy + " contains " + lastDay + " days");
        
    } // end of main   
    
    /*
        gets user year input
    */
    public static int getUserYear()
    {
        int userYear = 0;
        Scanner input;
        while(true)
        {
            try{
                input  = new Scanner (System.in);
                System.out.println("Enter full year (e.g., 2001): ");
                userYear = input.nextInt();
                return userYear;
            } // end of try
            catch(Exception e){
                System.out.println("Non Numberic. Please try again...");                
            } // end of catch            
        } // end of while true
    } // end of getUserYear
    
    /*
        gets user month
    */
    public static int getUserMonth()
    {
        int userMonth = 0;
        Scanner input;
        while(true)
        {
            try{
                input  = new Scanner (System.in);
                System.out.println("Enter month in number between 1 and 12: ");
                userMonth = input.nextInt();
                return userMonth;
            } // end of try
            catch(Exception e){
                System.out.println("Non Numberic. Please try again...");                
            } // end of catch            
        } // end of while true
    } // end of getUserYear
    
    /** Print the calendar for a month in a year */
  public static void printMonth(int year, int month) {
    // Print the headings of the calendar
    printMonthTitle(year, month);

    // Print the body of the calendar
    printMonthBody(year, month);
  } // end of printMonth
    
    /** Print the month title, e.g., May, 1999 */
  public static void printMonthTitle(int year, int month) {
    System.out.println("         " + getMonthName(month)
      + " " + year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  } // end of printMonthTitle

  /** Get the English name for the month */
  public static String getMonthName(int month) {
    String monthName = "";
    switch (month) {
      case 1: monthName = "January"; break;
      case 2: monthName = "February"; break;
      case 3: monthName = "March"; break;
      case 4: monthName = "April"; break;
      case 5: monthName = "May"; break;
      case 6: monthName = "June"; break;
      case 7: monthName = "July"; break;
      case 8: monthName = "August"; break;
      case 9: monthName = "September"; break;
      case 10: monthName = "October"; break;
      case 11: monthName = "November"; break;
      case 12: monthName = "December";
    } // end of switch case

    return monthName;
  } // end of getMonthName

  /** Print month body */
  public static void printMonthBody(int year, int month) {
    // Get start day of the week for the first date in the month
    int startDay = getStartDay(year, month);

    // Get number of days in the month
    int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

    // Pad space before the first day of the month
    int i = 0;
    for (i = 0; i < startDay; i++)
      System.out.print("    ");

    for (i = 1; i <= numberOfDaysInMonth; i++) {
      System.out.printf("%4d", i);

      if ((i + startDay) % 7 == 0)
        System.out.println();
    } // end of for loop

    System.out.println();
  } // end of printMonthBody

  /** Get the start day of month/1/year */
  public static int getStartDay(int year, int month) {
    final int START_DAY_FOR_JAN_1_1800 = 3;
    // Get total number of days from 1/1/1800 to month/1/year
    int totalNumberOfDays = getTotalNumberOfDays(year, month);

    // Return the start day for month/1/year
    return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
  }  // end of getStartDay

  /** Get the total number of days since January 1, 1800 */
  public static int getTotalNumberOfDays(int year, int month) {
    int total = 0;

    // Get the total days from 1800 to 1/1/year
    for (int i = 1800; i < year; i++)
      if (isLeapYear(i))
        total = total + 366;
      else
        total = total + 365;

    // Add days from Jan to the month prior to the calendar month
    for (int i = 1; i < month; i++)
      total = total + getNumberOfDaysInMonth(year, i);

    return total;
  } // end of getTotalNumberOfDays

  /** Get the number of days in a month */
  public static int getNumberOfDaysInMonth(int year, int month) {
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
      return 31;

    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;

    if (month == 2) return isLeapYear(year) ? 29 : 28;

    return 0; // If month is incorrect
  } // end of getNumberOfDaysInMonth

  /** Determine if it is a leap year */
  public static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  } // end of isLeapYear  
    
} // end of printCalendar
    