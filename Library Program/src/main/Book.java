package main;

import java.util.ArrayList;

public class Book {
	
	private String title;
	private String author;
	private Date date;
	private boolean checkedOut;
	private String borrower;
	
	public Book(String t, String a) {
		title = t;
		author = a;
		checkedOut = false;
		borrower = "";
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String toString() {
		return title + "\n" + author;
	}
	
	public void setDate(int m, int d, int y) {
		date = new Date(m, d, y);
	}
	
	private void resetDate() {
		date = new Date(0,0,0);
	}
	
	public boolean isOverdue() {
		return date.isOverdue();
	}
	
	public boolean isFuture() {
		return date.isFuture();
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public void checkOut(boolean b) {
		checkedOut = b;
		if(!b) {
			borrower = "";
			resetDate();
		}
	}
	
	public String getDateBorrowed() {
		return date.getDate();
	}
	
	public void setBorrower(String b) {
		borrower = b;
	}
	
	public String getBorrower() {
		return borrower;
	}
}