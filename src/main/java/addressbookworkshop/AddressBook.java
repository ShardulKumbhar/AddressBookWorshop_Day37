package addressbookworkshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	/**
	 * Procedure
	 * =============================================
	 * 1.created arrayList
	 * 2. Method to add Contacts
	 * 3.checking wether 1st name is same or not 
	 * 4.creating object of class
	 * ==========================================
	 */

	/*
	 * 1.created arrayList
	 */
	static Scanner sc = new Scanner(System.in);
	static List<Person> list = new ArrayList<Person>();
	static Person person;

	/*
	 *2. Method to add Contacts
	 */
	public void addContact() {
		System.out.println("Enter First Name: ");
		String firstName = sc.next();
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		System.out.println("Enter Address: ");
		String address = sc.next();
		System.out.println("Enter City Name: ");
		String city = sc.next();
		System.out.println("Enter State Name: ");
		String state = sc.next();
		System.out.println("Enter Zip code: ");
		String zip = sc.next();
		System.out.println("Enter Phone Number: ");
		String phno = sc.next();
		System.out.println("Enter email address: ");
		String emailId = sc.next();

		/*
		 * 3.checking wether 1st name is same or not 
		 */
		if (list.size() > 0) {
			for (Person personList : list) {
				person = personList;
				if (firstName.equals(person.firstName)) {
					System.out.println("Person with name : " + person.firstName + " already exists!!!");
					break;

				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Well Come to Address Book Workshop");
		/*
		 * 4.creating object of class
		 */
		AddressBook addressbook = new AddressBook();
		addressbook.addContact();
	}
}
