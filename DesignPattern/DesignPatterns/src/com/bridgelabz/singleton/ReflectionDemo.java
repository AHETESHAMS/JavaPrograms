package com.bridgelabz.singleton;

import java.lang.reflect.Constructor;

class Singleton 
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
 
public class ReflectionDemo 
{
 
    public static void main(String[] args)
    {
        Singleton object1 = Singleton.getInstance();
        Singleton object2 = null;
        try
        {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) 
            {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                object2 = (Singleton) constructor.newInstance();
                break;
            }
        }catch (Exception e) 
        {
            e.printStackTrace();
        }
         
    System.out.println("object1 .hashCode():- " + object1.hashCode());
    System.out.println("object2.hashCode():- " + object2.hashCode());
    }
}

