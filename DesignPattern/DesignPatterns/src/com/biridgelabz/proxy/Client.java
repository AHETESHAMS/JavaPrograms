package com.biridgelabz.proxy;

public class Client 
{ 
    public static void main (String[] args) 
    { 
        Internet internet = new ProxyInternet(); 
        try
        { 
            internet.connectTo("rekhta.org"); 
            internet.connectTo("abc.com"); 
        } 
        catch (Exception e) 
        { 
            System.out.println(e.getMessage()); 
        } 
    } 
} 