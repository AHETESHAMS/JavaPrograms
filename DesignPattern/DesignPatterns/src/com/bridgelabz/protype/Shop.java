package com.bridgelabz.protype;

import java.awt.List;
import java.util.ArrayList;

public class Shop  implements Cloneable 
{
	private String shopName;
	ArrayList books= new ArrayList();
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ArrayList getBooks() {
		return books;
	}
	public void setBooks(ArrayList books) {
		this.books = books;
	}
	public void loadData()
	{
		for(int i=1;i<10;i++)
		{
			Book b = new Book();
			b.setBookId(i);
			b.setBookName("Book"+i);
			getBooks().add(b);
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", books=" + books + "]";
	}
	
}


