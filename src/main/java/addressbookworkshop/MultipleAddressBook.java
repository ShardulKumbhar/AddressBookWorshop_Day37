package addressbookworkshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {
	static Person person;
	Map<String, AddressBookServer> addressBookSystem = new HashMap<String, AddressBookServer>();
	Scanner sc = new Scanner(System.in);
	AddressBookServer addressBookServer = new AddressBookServer();

	public void AddMultipleAddressBook() {
		System.out.println("Enter the name of address book :");
		String bookName = sc.next();

		if (addressBookSystem.containsKey(bookName)) {
			System.out.println("Book Already Exists");
			AddMultipleAddressBook();
		} else {
			AddressBookServer service = new AddressBookServer();
			addressBookSystem.put(bookName, service);
			System.out.println("created new address book");
			System.out.println("press 1 if you want to add another Address book or press any key to exit.");
			int newBook = sc.nextInt();
			if (newBook == 1) {
				AddMultipleAddressBook();

			}
		}
	}

	/*
	 * Adding contacts to addressbook
	 */
	public void addingContacts() throws Exception {
		System.out.println("Enter name of Address Book: ");
		String findBook = sc.next();
		try {
			AddressBookServer scr = addressBookSystem.get(findBook);
			if (scr == null) {
				System.out.println("Book Not Exist");
			} else {
				scr.checkForDuplicate();
			}
		} catch (Exception e) {
			addingContacts();
		}

	}

	public void noOfContactsToAdd() throws Exception {
		try {

			System.out.println("Enter Number of Contacts to Add");
			int a = sc.nextInt();
			for (int i = 1; i <= a; i++) {
				addingContacts();
			}
		} catch (Exception e) {
			System.out.println("Please Enter Valind number");
		}
	}

	public void deleteContactInBook() throws Exception {
		System.out.println("Enter Name of Address Book you want to delete the contacts in it: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookSystem.containsKey(bookName)) {
			addressBookSystem.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteContactInBook();
		}
	}

	public void displayBook() {
		for (String i : addressBookSystem.keySet()) {
			System.out.println(i);
			System.out.println(addressBookSystem.get(i).contact);
		}

	}

	/*
	 * We have used the get(key) metod to print the contacts.
	 */
	public void printContactsInBook() {
		for (String i : addressBookSystem.keySet()) {
			System.out.println(i);
			System.out.println(addressBookSystem.get(i).contact);
		}
		System.out.println(" ");
	}

	/*
	 * In this method we are searching the person by the city
	 */
	public void searchByCity() {

		System.out.println("Enter the name of the City to get the persons : ");
		String cityName = sc.next();
		for (String i : addressBookSystem.keySet()) {
			List<Person> arr = addressBookSystem.get(i).contact;
			arr.stream().filter(person -> person.getCity().equals(cityName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	/*
	 * In this method we are searching the person by the state
	 */
	public void searchByState() {

		System.out.println("Enter the name of the State to the get persons : ");
		String stateName = sc.next();
		for (String i : addressBookSystem.keySet()) {
			List<Person> arr = addressBookSystem.get(i).contact;
			arr.stream().filter(person -> person.getState().equals(stateName))
					.forEach(person -> System.out.println(person.getFirstName()));

		}
	}

}
