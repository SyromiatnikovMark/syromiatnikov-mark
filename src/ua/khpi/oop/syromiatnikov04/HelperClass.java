package ua.khpi.oop.syromiatnikov04;

public class HelperClass {
	/*Method of replacing k`th position with symbol*/
	public static StringBuilder replaceInPosition(StringBuilder text, int cnt, String chaReplace, int pos, boolean debug) {
		
		String[] words = text.toString().split("\\s+");
		if(debug) {
			
			System.out.println("Here you can see intermediate information of builded string.");
			System.out.println("__________________________");
			System.out.printf("%10s | %10s  |\n", "Original","Moded word"); 
			System.out.println("__________________________");
			for (String subStr: words) {
				StringBuilder strBul = new StringBuilder(subStr);
				strBul.replace(pos-1, pos, chaReplace);
				System.out.printf("%10s | %10s  |\n", subStr,strBul); 
			}
			System.out.println("__________________________");
			}
		
		for (int i = 0; i < text.length(); i++,cnt++) {	
			if (text.charAt(i) == ' ' && cnt <= pos){
				cnt = 0;
			}
			if(text.charAt(i) == ' ' || text.charAt(i) == '.'|| text.charAt(i) == '!' || text.charAt(i) == '?' || text.charAt(i) == '\0') {
				text.replace(i-cnt+pos,i-cnt+pos+1,chaReplace);
				cnt = 0;
			}			
		}
	
		return text;
	}
	/*Method of outputting data*/
	public static void outputData(StringBuilder text, String str, int cnt, String chaReplace, int pos){
		System.out.println("__________________________________________________________________");
		System.out.println("Yoyr string        | Position   |  Symbol    | Result string        |");
		System.out.printf("%s | %10d | %10s | %20s |\n", str,pos,chaReplace,text );
		System.out.println("__________________________________________________________________");
	}
}
