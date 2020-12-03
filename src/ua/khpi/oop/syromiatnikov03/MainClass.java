  /**
 * Lab 3 "Знайти к-й символ в слові та заминти його".
 * @author Syromiatnikov M.
 * @version 1.0
 */


package ua.khpi.oop.syromiatnikov03;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	    // System.out.print("Input string: ");
	    // String str = in.nextLine();
	     System.out.print("Input symbol to replace: ");
	     String chaReplace = in.nextLine();
	     if(chaReplace.length() > 1) {
	    	 System.out.println("ERROR: Not a symbol");
	    	 in.close();
	    	 return;
	     }
	     System.out.print("Input position: ");
	     int pos = in.nextInt();
	     in.close();
	     
	     String strMas = "I hate my life. Were all are doomed? I`m the storm that is aproaching!";
	     StringBuffer text = new StringBuffer(strMas);	
	     int cnt = 1;
		
		if(pos > text.length())
		{
			System.out.println("Error: Position is greater then length of string.");
	
			System.out.println("_____________________________________________________________________________________________________________________________________________________________________________");
			System.out.println("Your string                                                            | Position   |  Symbol    | Result string        ");
			System.out.printf("%s | %10d | %10s | %20s |\n", strMas,pos,chaReplace,text );
			System.out.println("____________________________________________________________________________________________________________________________________________________________________________________");
			return;
		}
		text = HelperClass.replaceInPosition(text, cnt, chaReplace, pos);
		System.out.println("_____________________________________________________________________________________________________________________________________________________________________________");
		System.out.println("Your string                                                            | Position   |  Symbol    | Result string        ");
		System.out.printf("%s | %10d | %10s | %20s |\n", strMas,pos,chaReplace,text );
		System.out.println("____________________________________________________________________________________________________________________________________________________________________________________");
	}
}
