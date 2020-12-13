package ua.khpi.oop.syromiatnikov08;

public class AdressBook {
	  private int arrLength = 3;
	  
	  /*Array of objects*/
	  Person[] array = new Person[3];
	  
	  /*Method that shows all elements in array*/
	  public void printAll() {
	    for (int i = 0; i < array.length; i++) {
	      System.out.println("Full name: "+ array[i].getFullName() + "\nDate of birth: " + array[i].getDateOfBirth() + "\nTelephone numbers: "+ array[i].showNumbers() + "\nAdress: " + array[i].getAdress() + "\nEditing date and time: " + array[i].getEditingDateAndTime() + "\n");
	      }
	  }	
	  /*Method that removes all items from the array*/
	  public void clear() {
		  array = null;
	  }	
	  /*Method that returns size of array*/
	  public int getSize() {
		  return arrLength;
	  }		
	  /*Method that adds the specified item to the end of the container*/
	  public void add(Person person) {
			Person arrNew[] = new Person[arrLength + 1];
			for (int i = 0; i < arrLength; i++) {
				arrNew[i] = array[i];
			}
			arrLength++;
			arrNew[arrLength - 1] = person;
			array = arrNew;
		}
	  /*Method that removes the first case of the specified element from the container*/
	  void remove(int num) {
		  Person arrNew[] = new Person[arrLength - 1];
		  for (int i = 0; i < num; i++) {	
			  arrNew[i] = array[i];
				}
				for (int i = num, j = num + 1; j < arrLength; i++, j++) {
					arrNew[i] = array[j];
				}
				arrLength--;
				array = arrNew;
		}
	  /*Method that creates new array with specified size*/
	  public void createNew(int num) {
			this.arrLength = num;
			array = new Person[arrLength];
		}	  
}