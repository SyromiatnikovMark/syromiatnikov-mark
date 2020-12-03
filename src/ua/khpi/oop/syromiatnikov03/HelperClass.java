package ua.khpi.oop.syromiatnikov03;

public class HelperClass {
	
	/*Method of replacing k`th position with symbol*/
	public static StringBuffer replaceInPosition(StringBuffer text, int cnt, String chaReplace, int pos) {
		
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
}
