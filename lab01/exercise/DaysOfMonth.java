// 250225 - Lab 01
// Exercise 6.4

import java.util.Scanner;
public class DaysOfMonth{
	public static String ValidMonth = "January|Jan.|Jan|1|February|Feb.|Feb|2|March|Mar.|Mar|3|April|Apr.|Apr|4|May|May.|May|5|June|Jun.|Jun|6|July|Jul.|Jul|7|August|Aug.|Aug|8|September|Sep.|Sep|9|October|Oct.|Oct|10|November|Nov.|Nov|11|December|Dec.|Dec|12";
	public static String[] months = {
            "January|Jan.|Jan|1", "February|Feb.|Feb|2", "March|Mar.|Mar|3",
            "April|Apr.|Apr|4", "May|May.|May|5", "June|Jun.|Jun|6",
            "July|Jul.|Jul|7", "August|Aug.|Aug|8", "September|Sep.|Sep|9",
            "October|Oct.|Oct|10", "November|Nov.|Nov|11", "December|Dec.|Dec|12"
};
	public static boolean isValidMonth(String month) {
		/* "January|Jan.|Jan|1" 
			+ "February|Feb.|Feb|2"  
			+ "March|Mar.|Mar|3"  
			+ "April|Apr.|Apr|4"  
			+ "May|May.|May|5"  
			+ "June|June|Jun|6"  
			+ "July|July|Jul|7"  
			+ "August|Aug.|Aug|8"  
			+ "September|Sept.|Sep|9"  
			+ "October|Oct.|Oct|10"  
			+ "November|Nov.|Nov|11"  
			+ "December|Dec.|Dec|12";*/
		
		return month.matches(ValidMonth);
	}
	
	public static int GetMonthNum(String strMonth, String[] months) {
		for(int i = 0; i < months.length; i++) {
			String[] parts = months[i].split("\\|");
			for(String part : parts) {
				if(part.equals(strMonth)) {
                    return Integer.parseInt(parts[parts.length - 1]);
				}
			}
		}
		return -1;
	}
	
	public static int DayInMonth(int month, int year) {
		int days = 0;
		switch(month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
        	days = 31;
        	break;
        case 4:
        case 6:
        case 9:
        case 11:
            days = 30;
            break;
        case 2:
            if(year%4 != 0) days = 28;
            else if(year%100 != 0) days = 29;
            else if(year%400 != 0) days = 28;
            else days = 29;
            break;
		}
		return days;
	}
	
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int year, month;
        
        while(true) {
	        System.out.println("Enter a month: ");
	        String strMonth = keyboard.nextLine();
            month = GetMonthNum(strMonth, months);
	        if(isValidMonth(strMonth)) {
	        	break;
	        } else System.out.println("Invalid! Please try again.");
        }
        
        while(true) {
            System.out.println("Enter a year: ");
            String strYear = keyboard.nextLine();
            year = Integer.parseInt(strYear);
	        if(year > 0) {
	        	break;
	        } else System.out.println("Invalid! Please try again.");
        }    
    int days = DayInMonth(month, year);
    System.out.println("Number of days: " + days);
    keyboard.close();
    }
}