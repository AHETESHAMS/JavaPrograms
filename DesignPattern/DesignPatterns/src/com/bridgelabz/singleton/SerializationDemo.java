package com.bridgelabz.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
class Singleton implements Serializable
{
    public static Singleton instance;
     
    private Singleton() 
    {
	
    }

    public static Singleton getInstance()
    {
    	if(instance == null)
			instance = new Singleton();
		return instance;
    }
}
 
 
public class SerializationDemo
{
 
    public static void main(String[] args) 
    {
        try
        {
            Singleton object1 = Singleton.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
            out.writeObject(object1);
            out.close();
     
            // deserailize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
             
            Singleton object2 = (Singleton) in.readObject();
            in.close();
     
            System.out.println("object1 hashCode:- " + object1.hashCode());
            System.out.println("object2 hashCode:- " + object2.hashCode());
        } 
         
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

