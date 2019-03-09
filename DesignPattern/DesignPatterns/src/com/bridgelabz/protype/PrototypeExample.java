package com.bridgelabz.protype;

import java.util.ArrayList;

public class PrototypeExample
{
	public static void main(String []args) throws CloneNotSupportedException
	{
		Shop bs = new Shop();
		bs.setShopName("Novelty");
		bs.loadData();
		System.out.println(bs);
		Shop bs1 = (Shop) bs.clone();
		bs1.setShopName("Cap");
		System.out.println(bs1);
	}
}
