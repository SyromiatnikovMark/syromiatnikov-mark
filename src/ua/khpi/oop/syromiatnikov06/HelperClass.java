package ua.khpi.oop.syromiatnikov06;
import java.util.Scanner;

public class HelperClass {
	/*Method of replacing k`th position with symbol*/
	public static StringBuilder replaceInPosition(StringBuilder text, int cnt) {
		
		Scanner in = new Scanner(System.in);

	     System.out.print("Input symbol to replace: ");
	     String chaReplace = in.nextLine();
	     if(chaReplace.length() > 1) {
	    	 System.out.println("ERROR: Not a symbol");
	    
	    	 return null;
	     }
	     
	     System.out.print("Input position: ");
	     int pos = in.nextInt();
	   
			System.out.println("__________________________________________________________________");
			System.out.printf("%s","Result string\n");
		for (int i = 0; i < text.length(); i++,cnt++) {	
			if (text.charAt(i) == ' ' && cnt <= pos){
				cnt = 0;
			}
			if(text.charAt(i) == ' ' || text.charAt(i) == '.'|| text.charAt(i) == '!' || text.charAt(i) == '?' || text.charAt(i) == '\0') {
				text.replace(i-cnt+pos,i-cnt+pos+1,chaReplace);
				cnt = 0;
			}		
			
		}
		outputData(text);
		return text;
	}
	/*Method of outputting data*/
	public static void outputData(StringBuilder text){
		System.out.printf("%s\n",text );
		System.out.println("__________________________________________________________________");
	}
}
