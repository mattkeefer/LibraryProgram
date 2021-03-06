package main;

import java.util.Calendar;

public class Date {
	private int[] dueDate = new int[2];
	private int[] toDayt = new int[2];
	private int month;
	private int day;
	private int year;
	
	public Date(int m, int d, int y) {
		dueDate = convertDate(m, d+14, y);
		toDayt = convertDate(Calendar.getInstance().get(Calendar.MONTH)+1, Calendar.getInstance().get(Calendar.DATE), Calendar.getInstance().get(Calendar.YEAR));
		month = m;
		day = d;
		year = y;
	}
	
	//determines if entered year is a leap year
	private boolean isLeapYear(int y) {
		return (y%4==0)&&(y%100!=0)||(y%400==0);
	}
	
	//determines if book is overdue
	public boolean isOverdue() {
		if(toDayt[0] > dueDate[0] && toDayt[1] >= dueDate[1]) {
			return true;
		}
		return false;
	}
	
	//determines if date book is checked out is after the current date
	public boolean isFuture() {
		int[] checkDate = convertDate(month, day, year);
		if(checkDate[0] > toDayt[0] && checkDate[1] >= toDayt[1]) {
			return true;
		}
		return false;
	}
	
	//converts day/month into a number out of 365/366
	private int[] convertDate(int mn, int dy, int yr) {
		int date = 0;
		int[] dateArr = new int[2];
		if(mn == 0) {
			dateArr = null;
			return dateArr;
		}
		switch(mn) {
		case 1 : //jan - 31
			break;
		case 2 : //feb - 28/29
			date += 31;
			break;
		case 3 : //mar - 31
			date += 59;
			break;
		case 4 : //apr - 30
			date += 90;
			break;
		case 5 : //may - 31
			date += 120;
			break;
		case 6 : //jun - 30
			date += 151;
			break;
		case 7 : //jul - 31
			date += 181;
			break;
		case 8 : //aug - 31
			date += 212;
			break;
		case 9 : //sep - 30
			date += 243;
			break;
		case 10 : //oct - 31
			date += 273;
			break;
		case 11 : //nov - 30
			date += 304;
			break;
		case 12 : //dec - 31
			date += 334;
			break;
		}
		date += dy;
		if(isLeapYear(yr) && mn>2) {
			date++;
		}
		if(date>365 && !isLeapYear(yr)) {
			date -= 365;
			yr++;
		}
		else if(date>366) {
			date -= 366;
			yr++;
		}
		dateArr[0] = date;
		dateArr[1] = yr;
		return dateArr;
	}
	
	public String getDate() {
		return month+"/"+day+"/"+year;
	}
}