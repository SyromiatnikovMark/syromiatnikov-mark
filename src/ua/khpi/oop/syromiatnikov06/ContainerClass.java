package ua.khpi.oop.syromiatnikov06;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContainerClass implements Serializable {

	String[] array;
	int arrLength;
	boolean isEmpty = false;

	/* Method of creating container */
	public ContainerClass(String... strings) {
		arrLength = strings.length;
		array = new String[arrLength];
		for (int i = 0; i < arrLength; i++) {
			array[i] = strings[i];
		}
	}

	/* Method making string from StrBuff */
	public String toString() {

		if (isEmpty) {
			System.out.println("There are no content in the container.");
			return null;
		}
		StringBuffer sb = new StringBuffer(array[0]);

		for (int i = 1; i < arrLength; i++)
			sb.append(array[i]);
		return sb.toString();
	}

	/* Method of adding new element to container */
	public void add(String string) {
		String[] newArray = new String[arrLength + 1];
		for (int i = 0; i < arrLength; i++) {
			newArray[i] = array[i];
		}
		arrLength++;
		newArray[arrLength - 1] = string;
		array = newArray;
	}

	/* Method of clearing the container */
	public void clear() {
		array = new String[0];
		isEmpty = true;
		System.out.println("There are no more content in the container.");
	}

	/* Method of removing thirst comparable object */
	public boolean remove(String string) {
		int cnt = 0;
		boolean match = false;

		String[] newArray = new String[arrLength];

		for (int i = 0; i < arrLength; i++, cnt++) {
			if (array[i].equals(string)) {
				match = true;
				break;
			}
		}

		if (match) {
			newArray = new String[arrLength - 1];

			for (int i = 0; i < cnt; i++) {
				newArray[i] = array[i];
			}
			for (int i = cnt; i < arrLength - 1; i++) {
				newArray[i] = array[i + 1];
			}
			arrLength--;
		}
		array = newArray;
		return match;
	}

	/* Method of makin object from container */
	public Object[] toArray() {
		String[] arrayCopy = new String[arrLength];
		for (int i = 0; i < arrLength; i++)
			arrayCopy[i] = array[i];
		return arrayCopy;
	}

	public int size() {
		int size = array.length;
		return size;
	}

	/* Method of checking containment of container */
	public boolean contains(String string) {
		for (int i = 0; i < arrLength; i++)
			if (array[i] == string)
				return true;
		return false;
	}

	/* Method of checking containment of container */
	public boolean containsAll(ContainerClass container) {
		if (arrLength < container.size() || container.size() == 0 || arrLength == 0) {
			return false;
		}
		System.out.println("Data in param. container - " + container.toString());
		System.out.println("Data in original container - " + this.toString());
		boolean check = false;
		for (int i = 0; i < arrLength; i++) {
			check = false;
			for (int j = 0; j < container.size(); j++) {
				if (array[i].equals(container.getData(j))) {
					check = true;
					break;
				}
			}
			if (!check) {
				return false;
			}
		}
		return true;
	}

	/* Method of help-method for iterator */
	public String getData(int i) {
		return array[i];
	}

	/* Method of making iterator for container */
	public Iterator<String> iterator() {
		return new iteratorNew<String>();
	}

	public class iteratorNew<String> implements Iterator {
		int index;
		boolean check = false;

		@Override
		/* Method of checking availability of next element */
		public boolean hasNext() {
			return index < arrLength;
		}

		@Override
		/* Method of checking availability of next element */
		public Object next() {
			if (index == arrLength) {
				throw new NoSuchElementException();
			}
			check = true;
			return array[index++];
		}

		@Override
		public void remove() {
			if (check) {
				ContainerClass.this.remove(array[index - 1]);
				check = false;
			} else {
				throw new IllegalStateException();
			}
		}
	}

	/* Method that finds chosen element and return its index in array */
	public int findElement(String str) {
		Iterator<String> it = this.iterator();
		int i = 0;
		while (it.hasNext()) {
			if (str.equals(it.next())) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/* Method that prints all elements */
	public void printAll() {
		for (String string : array) {
			System.out.println(string);
		}
		System.out.println("\n");
	}

	public void sorting() {
		for (int a = 0; a < arrLength - 1; a++) {
			for (int b = a + 1; b < array.length; b++) {
				if (array[a].compareTo(array[b]) > 0) {
					String temp = array[a];
					array[a] = array[b];
					array[b] = temp;
				}
			}
		}
	}
	
}
