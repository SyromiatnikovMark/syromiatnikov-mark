package ua.khpi.oop.syromiatnikov01;

public class C_Lab01 {

	public static void main(String[] args) {

		int hex = 0x12708969;
		long longNumber = 380999063630l;
		int binary = 0b111111;
		int octal = 014333;
		int expression = (18-1)%26 + 1;
		char symbol = 'R';
	
		countPairedNumbers(longNumber);
		countPairedNumbers(binary);
		countPairedNumbers(octal);
		countPairedNumbers(hex);
		countPairedNumbers(expression);

		String str1 = Long.toBinaryString(longNumber);
		String str2 = Integer.toBinaryString(binary);
		String str3 = Integer.toBinaryString(octal);
		String str4 = Integer.toBinaryString(expression);
		String str5 = Integer.toBinaryString(hex);

		countOnes(str1);
		countOnes(str2);
		countOnes(str3);
		countOnes(str4);
		countOnes(str5);
	}

	static void countPairedNumbers(long num) {
		int paired = 0;
		int nonPaired = 0;
		while (num > 0) {
			if (num % 2 == 0) {
				paired++;
			} else {
				nonPaired++;
			}
			num = num/10;
		}
	
	}

	static void countOnes(String str) {
		int cnt = 0;
		long number = Long.parseLong(str, 2);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				cnt++;
			}
		}
	}
} 
