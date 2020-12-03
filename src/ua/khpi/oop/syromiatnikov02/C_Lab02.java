package ua.khpi.oop.syromiatnikov02;

import java.util.*;

public class C_Lab02 {
	public static void main(String[] args) {
		
		System.out.println("            Decemal  |" + "         Hexidecimal |"+ "     Quantity of letters |");	// "hat" of the table
		System.out.println("______________________________________________________________________");
		generatingNumbers();
		
}

static int countLettersInHex(int num) {
	
		int counter = 0;		// initialization of counter
		 
			while (num > 0) {	
				if (num % 16 > 9) {	// division by 16 with reminder 
					counter++;		// increasing counter
				} 
				num = num/16;		// cutting off the tale of the number
			}
		return counter;			// function returning the counter
}

static void generatingNumbers()
{
	int temp = 0;
	
	Random random = new Random();		// object Random
	
	for (int i = 0; i < 11; i++) {
		
    	int number = random.nextInt(); 	// generating number
    	
    	if (number < 0) {				// checking for negative number
    		temp = number;
    		number *= -1;
    		
    		int result = countLettersInHex(number);	
    		System.out.printf("%20d |", temp);
    		System.out.printf("%20x |", number);
    		System.out.printf("%20d     |\n", result);
    	}
    	else {
    		int result = countLettersInHex(number);	// summoning the function of counting
    		System.out.printf("%20d |", number);
    		System.out.printf("%20x |", number);
    		System.out.printf("%20d     |\n", result);	// calling the output of table
    	}
    	System.out.println("______________________________________________________________________");
    }  
}

}


