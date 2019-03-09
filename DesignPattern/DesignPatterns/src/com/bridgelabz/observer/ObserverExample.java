package com.bridgelabz.observer;

public class ObserverExample {

	public static void main(String[] args) {
		Person akashPerson=new Person("Akash");
	    Person johnPerson=new Person("John");
	    
	    Product samsungMobile=new Product("Samsung", "Mobile", "Not available");
	    
	    //When you opt for option "Notify me when product is available".Below registerObserver method
	    //get executed   
	    samsungMobile.registerObserver(akashPerson);
	    samsungMobile.registerObserver(johnPerson);
	    
	    //Now product is available
	    samsungMobile.setAvailability("Available");

	}

}
