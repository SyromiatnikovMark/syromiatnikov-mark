package ua.khpi.oop.syromiatnikov07;

import java.util.ArrayList;

public class Person {
  private String fullName;
  private String dateOfBirth;
  private long telephoneNumbers[];
  private String adress;
  private String editingDateAndTime;
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public String getDateOfBirth() {
    return dateOfBirth;
  }
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  public String getAdress() {
    return adress;
  }
  public void setAdress(String adress) {
    this.adress = adress;
  }
  public String getEditingDateAndTime() {
    return editingDateAndTime;
  }
  public void setEditingDateAndTime(String editingDateAndTime) {
    this.editingDateAndTime = editingDateAndTime;
  }

public Person(String fullName, String dateOfBirth, long[] telephoneNumbers, String adress, String editingDateAndTime) {
	super();
	this.fullName = fullName;
	this.dateOfBirth = dateOfBirth;
	this.telephoneNumbers = telephoneNumbers;
	this.adress = adress;
	this.editingDateAndTime = editingDateAndTime;
}
public long[] getTelephoneNumbers() {
	return telephoneNumbers;
}
public void setTelephoneNumbers(long[] telephoneNumbers) {
	this.telephoneNumbers = telephoneNumbers;
}
public String showNumbers() {
    StringBuilder sb = new StringBuilder();
    if (telephoneNumbers.length > 1) {
      for (int i = 0; i < telephoneNumbers.length; i++) {
        sb.append(telephoneNumbers[i] + " ");
      }
        return sb.toString();
      }
      
      return sb.append(telephoneNumbers[0]).toString();
    }

}