  /**
 * Lab 4 "Знайти к-й символ в слові та заминти його. Створити меню з відповідними пунктами". 
 * @author Syromiatnikov M.
 * @version 1.0
 */
package ua.khpi.oop.syromiatnikov04;
import java.util.Scanner;

public class MainClass {
	/*Method of calling the menu.*/
	public static void main(String[] args) {
		boolean debug = false;
		for (String string : args) {
			if (string.equals("-help") || string.equals("-h")) {
				System.out.println("Programmer: Mark Syromiatnikov");
				System.out.println("Task: Make menu. Enter text, replace every k`th symbol with the entered.");
				System.out.println("NTU KHPI 2020");
				menu(debug);
			} 
			if (string.equals("-debug") || string.equals("-d")) {
				debug = true;
			    System.out.println("______________________________________________");
				System.out.println("Debug mode started.");
			   	System.out.println("______________________________________________");
				menu(debug);
				}	
		}
		menu(debug);	
		}
		
	public static void menu(boolean debug) {
		boolean tryIt = true;
		String str = "Example for debag.";
		StringBuilder in = new StringBuilder(str);
		int cnt = 1;
		String chaReplace = "@";
		int pos = 2;
		
		while(tryIt) {
			System.out.println("1. Enter data.");
			System.out.println("2. Show current.");
			System.out.println("3. Do task (Replace every k`th symbol of the word with entered or by default).");
			System.out.println("4. Show result in table.");
			System.out.println("5. Close menu.");
			System.out.println("Chose number of option : ");
			Scanner sc = new Scanner(System.in);
			int answer = sc.nextInt();
			switch(answer) {
			case 1: 
				Scanner sc1 = new Scanner(System.in);
				
				in.delete(0, in.length());
							
		   	 	System.out.print("Input string: ");
		   	 	in.append(sc1.nextLine());
		   	 
		   	 	System.out.print("Input symbol to replace: ");
		   	 	chaReplace= sc1.nextLine();
		   	 	System.out.print("Input position: ");
		   	 	pos = sc1.nextInt();
		   	 	System.out.println("______________________________________________");	
		   	 	System.out.println("Data have been succsessfully entered.");
		   	 	System.out.println("______________________________________________");
			    StringBuffer text = new StringBuffer(in);			     
			    str = text.toString();
			     if(pos > text.length())
			     	{
			    	 System.out.println("Error: Position is greater then length of string.");
			    	 sc1.close();
			    	 return;
			     	} 
			     break;
			     
			case 2: 
				System.out.println();
				System.out.println("\nCurrent string is : " + in);
				System.out.println("\nCurrent position is : " + pos);
				System.out.println("\nCurrent symbol is : " + chaReplace);
				System.out.println(" ");
				break;
				
			case 3:
				in = HelperClass.replaceInPosition(in, cnt, chaReplace, pos, debug);
				System.out.println("______________________________________________");	
				System.out.println("Task completed successfully");
				System.out.println("______________________________________________");	
				break;			
			case 4: 
				HelperClass.outputData(in, str, cnt, chaReplace, pos);
				break;
			case 5:
				tryIt = false;
				System.out.println("End______________________________________________");
				break;
			default:
				System.out.println("Error: Out of range of variation. Try one more time. \n");
			};
		}
	}
}
