package ua.khpi.oop.syromiatnikov07;

public class AdressBook {
	  /*Array of objects*/
	  Person[] array = new Person[3];
	  
	  /*Method that shows all elements in array*/
	  public void printAll() {
	    for (int i = 0; i < array.length; i++) {
	      System.out.println("Full name: "+ array[i].getFullName() + "\nDate of birth: " + array[i].getDateOfBirth() + "\nTelephone numbers: "+ array[i].showNumbers() + "\nAdress: " + array[i].getAdress() + "\nEditing date and time: " + array[i].getEditingDateAndTime() + "\n");
	      }
	  }
}