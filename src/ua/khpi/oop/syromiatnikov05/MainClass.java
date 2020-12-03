  /**
 * Lab 5 "Розробити контейнер та ітератор відповідно до заданого масиву рядків"
 * @author Syromiatnikov M.
 * @version 1.0
 */
package ua.khpi.oop.syromiatnikov05;

import java.util.Iterator;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		int testSize = 0;
		String testStr = "Second string";
		
		Object[] arrCp = null;
		ContainerClass cr = new ContainerClass("Thirst string", "Second string", "Second string", "Third String");
		Iterator<String> iter = cr.iterator();
		System.out.println("_____________________________________________________");
		System.out.println("Here is the date inside container.");
		for(;iter.hasNext();) {
			System.out.println(iter.next());
		}
		System.out.println("__________________________________________________________________________________");
		System.out.println("Testing add metod. Adding string 'Abrakadabra'.");
		cr.add("Abrakadabra");
		boolean match = cr.remove(testStr);
		System.out.println("Testing removing metod. Removing string 'Second string'.");
		System.out.println("Returning result of previous 2 methods as string object.");
		System.out.println("__________________________________________________________________________________");
		String toString = cr.toString();
		System.out.println("String = " + toString);
		System.out.println("__________________________________________________________________________________");		
		arrCp = cr.toArray();
		testSize = cr.size();
		System.out.println("Testing size metod. Current size of container is " + testSize);
		System.out.println("__________________________________________________________________________________");	
		System.out.println("Testing contains metod. Does the container contains string 'Abrakadabra'?");
		boolean isThere = cr.contains("Abrakadabra");
		if(isThere)
			System.out.println("Contains!");
		else 
			System.out.println("Do not contains!");
		System.out.println("__________________________________________________________________________________");	
		iter = cr.iterator();
		System.out.println("Here you can see resulted data displayed with while cycle.");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("__________________________________________________________________________________");	
	}
}

