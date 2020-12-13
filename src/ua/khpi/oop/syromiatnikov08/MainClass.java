package ua.khpi.oop.syromiatnikov08;

import java.beans.XMLDecoder; 
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		AdressBook ab = new AdressBook();
		ab.array[0] = new Person("Марк","12.12.2020",new long[] {1,2,3},"Morozova.St", "12.12.2020");
		ab.array[1] = new Person("МаРК","12.12.2020",new long[] {1,2,3},"Morozova.St", "12.12.2020");
		ab.array[2] = new Person("Карк","12.12.2020",new long[] {1,2,3},"Morozova.St", "12.12.2020");
		String fileName = "Bean.xml";
		boolean menu = true;
		int number = 0;
		boolean fileCheck = false;
		Scanner option = new Scanner(System.in);
		Scanner someData = new Scanner(System.in);
		while (menu) {
			System.out.println("1 - Show current data");
			System.out.println("2 - Add element");
			System.out.println("3 - Serialize current data to XML");
			System.out.println("4 - Deserialize from XML file");
			System.out.println("5 - Delete element");
			System.out.println("6 - Exit");
			System.out.println("Enter your option:");
			int someNum = option.nextInt();
			System.out.println("\n");
			switch (someNum) {
			case 1:
				ab.printAll();
				break;
			case 2:
				System.out.println("Enter full name: ");
				String fullName = someData.nextLine();
				System.out.println("Enter year/month/date of birth: ");
				String dob = someData.nextLine();
				System.out.println("Enter how many telephone numbers will person have: ");
				int amOfNums = option.nextInt();
				long nums[] = null;
				if (amOfNums > 0) {
					nums = new long[amOfNums];
					if (amOfNums == 1) {
						System.out.println("Enter telephone number: ");
						nums[0] = option.nextLong();
					} else {
					for (int j = 0; j < amOfNums; j++) {
						System.out.println("Enter telephone number: ");
						nums[j] = option.nextLong();
					}
				  }
				} else {
					System.out.println("You`ve entered something completely incorrect");
				}
				System.out.println("Enter persons adress: ");
				String adress = someData.nextLine();
				System.out.println("Enter date and time of editing: ");
				String dAT = someData.nextLine();
				ab.add(new Person(fullName, dob, nums, adress, dAT));
				ab.printAll();
				break;
			case 3:
				int index = 0;
				boolean cycle = true;
				boolean input = false;
				StringBuilder sb = new StringBuilder(new File("").getAbsolutePath());
				String pathToFile = sb.toString();
				StringBuilder var = new StringBuilder();
				System.out.println("Name of XML file - " + fileName);
				
				File directoryPath = new File(sb.toString());
				File files[] = directoryPath.listFiles();
				while (cycle) {
				      System.out.println("Current path: " + sb + "\nList of all directories:");
				      System.out.println(1 + ") Save here");
				      System.out.println(2 + ") Go one folder up");
				      for(index = 0; index < files.length; index++) {
				         System.out.println(index + 3 + ") " + files[index]);
				      }
				      System.out.println("Go to the other directory or save file here:");
				      number = option.nextInt();
				      
				      if (number > index+3 || number < 1) {
				    		System.out.println("Wrong number, try again");
				    		continue;
				      }
				      
				    if (number == 1) {
						break;
					} else if (number == 2) {
						if (sb.toString().equals(pathToFile)) {
							System.out.println("This is top folder, you can`t go up from here");
							continue;
						} else 
							sb.delete(sb.indexOf(directoryPath.getName()) - 1, sb.length());
				    } else {
				    	var.delete(0, var.length());
				    	var.append(sb);
				    	sb.delete(0, sb.length());
				    	sb.append(files[number - 3]);					
					}
				    directoryPath = new File(sb.toString());
				    files = directoryPath.listFiles();
				    if(files == null) {
				    	System.out.println("ERROR! Not a directory");
				    	 sb.delete(0, sb.length());
			             sb.append(var);
			             directoryPath = new File(sb.toString());
						 files = directoryPath.listFiles();
				    }
				}
			    File dir = new File(sb.toString());
			    File actualFile = new File (dir, fileName);
				try {
					XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(actualFile)));
					encoder.writeObject(ab.array);
					encoder.close(); 
					System.out.println("Serialization successful\n");
					fileCheck = true;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				sb = new StringBuilder(new File("").getAbsolutePath());
		        pathToFile = sb.toString();
		        var = new StringBuilder();
		        cycle = true;
		        directoryPath = new File(sb.toString());
		        files = directoryPath.listFiles();
		        while (cycle) {
		           System.out.println("Current path: " + sb + "\nList of all files and directories:");
				      System.out.println(1 + ") Go one folder up");
		              for(index = 0; index < files.length; index++) {
		                 System.out.println(index + 2 + ")  " + files[index]);
		              }
		            System.out.println("Enter number of directory for moving there or the XML file what you want to read: ");
		            number = option.nextInt();
		            
		            if (number > index + 2 || number < 1) {
			    		System.out.println("Wrong number, try again");
			    		continue;
		            }
			      
		            
		            if (number == 1) {
		                  if (sb.toString().equals(pathToFile)) {
		                    System.out.println("You cant go up from this directory");
		                    continue;
		                } else 
		              sb.delete(sb.indexOf(directoryPath.getName()) - 1, sb.length());
		            } else {
		              var.delete(0, var.length());
		              var.append(sb);
		              sb.delete(0, sb.length());
		              sb.append(files[number - 2]);          
		          }
		            directoryPath = new File(sb.toString());
		            files = directoryPath.listFiles();
		            if(files == null) {
		              System.out.println("ERROR! Not a directory");
		               sb.delete(0, sb.length());
		                   sb.append(var);
		                   directoryPath = new File(sb.toString());
		             files = directoryPath.listFiles();
		            }
		        }
		        dir = new File(sb.toString());                        
		        try {
		          XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(dir)));
		          ab.array =  (Person[]) decoder.readObject();
		          decoder.close();
		          for (var hotelRoom : ab.array) {
		            System.out.println("Full name: "+ hotelRoom.getFullName() + "\nDate of birth: " + hotelRoom.getDateOfBirth() + "\nTelephone numbers: "+ hotelRoom.showNumbers() + "\nAdress: " + hotelRoom.getAdress() + "\nEditing date and time: " + hotelRoom.getEditingDateAndTime() + "\n");
		              }
		        } catch (FileNotFoundException e) {
		          e.printStackTrace();
		        }
		        break;
			case 5:
				System.out.println("Enter number of element which you want to delete: ");
				number = option.nextInt();
				if (number < ab.getSize() && number > -1) {
					ab.remove(number);
					System.out.println("Removing complete\n");
					ab.printAll();
				} else {
					System.out.println("There is no such element in array");
				}
				break;
			case 6:
				menu = false;
				option.close();
				someData.close();
				break;
			default:
				System.out.println("Wrong command");
				break;
			}
		}
		System.out.println("End of work");
	}
}