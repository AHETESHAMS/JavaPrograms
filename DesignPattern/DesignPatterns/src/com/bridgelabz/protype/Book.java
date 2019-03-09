package com.bridgelabz.protype;

public class Book {
	String bookName;
	int bookId;
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookId=" + bookId + "]";
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
	

