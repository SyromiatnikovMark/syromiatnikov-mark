package ua.khpi.oop.syromiatnikov06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;

import projForJar.MinMaxWords;

public class MainClass {

	public static void main(String[] args) throws FileNotFoundException {
		ContainerClass cont = new ContainerClass("3One", "2Two dfsadfasdfasdf.", "1Vhree dfsadfasdf dfasdfasdf dsf.");
		boolean menu = true;
		int cnt = 1;
		Scanner option = new Scanner(System.in);
		Scanner someData = new Scanner(System.in);
		while (menu) {
			System.out.println("1 - Показать данные");
			System.out.println("2 - Добавить элемент");
			System.out.println("3 - Выполнить задачу");
			System.out.println("4 - Сериализация");
			System.out.println("5 - Десериализация");
			System.out.println("6 - Выполнить задачу другого студента");
			System.out.println("7 - Удалить элемент");
			System.out.println("8 - Найти элемент");
			System.out.println("9 - Сравнить контейнеры");
			System.out.println("10 - Сортировать контейнер");
			System.out.println("11 - Выход");
			System.out.println("Введите выполняемую опцию:");
			
			int someNum = option.nextInt();
			System.out.println("\n");
			switch (someNum) {
			case 1:
				cont.printAll();
				break;
			case 2:
				System.out.println("Введите данные для добавления:\n");
				cont.add(someData.nextLine());
				cont.printAll();
				break;
			case 3:
					StringBuilder sb = new StringBuilder(cont.toString());
					HelperClass.replaceInPosition(sb, cnt);
					break;
			case 4:
				FileOutputStream fs = new FileOutputStream("Сериализация.ser");
				try {
					ObjectOutputStream os = new ObjectOutputStream(fs);
					os.writeObject(cont);
					os.close();
					System.out.println("Сериализация успешна\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Сериализация неудачна\n");
				}
				break;
			case 5:
				FileInputStream fis = new FileInputStream("Сериализация.ser");
				try {
					ObjectInputStream ois = new ObjectInputStream(fis);
					ContainerClass cont2 = (ContainerClass) ois.readObject();
					ois.close();
					Iterator<String> itearator = cont2.iterator();
					while (itearator.hasNext()) {
						System.out.println(itearator.next());
					}
					System.out.println("\n");
					System.out.println("Десериализация успешна\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Десериализация неудачна\n");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Десериализация неудачна\n");
				}
				break;
			case 6:
					MinMaxWords.findMinMaxWords(cont.toString());
					break;
			case 7:
				System.out.println("Введите элемент, который надо удалить:\n");
				boolean result = cont.remove(someData.nextLine());
				if (result) {
					System.out.println("Удаление успешно");
					cont.printAll();
				} else {
					System.out.println("Такого элемента нет\n");
				}
				break;
			case 8:
				System.out.println("Введите элемент, что надо найти:\n");
				int var = cont.findElement(someData.nextLine());
				if (var != -1) {
					System.out.println("Позиция искомого элемента в контенере - " + var + "\n");
				} else {
					System.out.println("Такого элемента нет\n");
				}
				break;
			case 9:
				System.out.println("Введите кол-во предложений");
				int sizeOne = option.nextInt();
				String tempCont[] = new String[sizeOne];
				for (int i = 0; i < tempCont.length; i++) {
					tempCont[i] = someData.nextLine();
				}
				ContainerClass varCont = new ContainerClass(tempCont);
				boolean check = cont.containsAll(cont);
				if (check) {
					System.out.println("Все жлементы присутствуют в контейнере\n");
				} else {
					System.out.println("В контейнере нет такого/таких элементов\n");
				}
				break;
			case 10:
				cont.sorting();
				cont.printAll();
				break;
			case 11:
				menu = false;
				break;
			default:
				System.out.println("Wrong command");
				break;
			}
		}
	}
}