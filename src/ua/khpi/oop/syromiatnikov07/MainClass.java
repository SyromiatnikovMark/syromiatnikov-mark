package ua.khpi.oop.syromiatnikov07;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		AdressBook ab = new AdressBook();
		ab.array[0] = new Person("����","12.12.2020",new long[] {1,2,3},"Morozova.St", "12.12.2020");
		ab.array[1] = new Person("����","12.12.2020",new long[] {1,2,3},"Morozova.St", "12.12.2020");
		ab.array[2] = new Person("������������","12.12.2020",new long[] {1,2,3},"Morozova.St", "12.12.2020");
		ab.printAll();
	}
}
