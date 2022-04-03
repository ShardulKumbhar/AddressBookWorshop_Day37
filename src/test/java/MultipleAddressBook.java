import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import addressbookworkshop.AddressBook;

public class MultipleAddressBook {

	Map<String, AddressBookServer> addressBookSystem = new HashMap<String, AddressBookServer>();
	Scanner sc = new Scanner(System.in);


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

	
	public void addingContacts() throws Exception {
		System.out.println("\nEnter name of adress book you want to add contatcts in");
		String existingBook = sc.next();
		try {

			addressBookSystem.get(existingBook);
			if (existingBook == null) {
				System.out.println("Book Not Exist");
			} else {
				addressBookSystem.get(existingBook).checkDublicate();

			}

		} catch (Exception e) {
			System.out.println("Address book not exist...!!!!  \nEnter valid address book ");
			addingContacts();
			// System.out.println(e);
		}
	}

	
	public void noOfContactsToAdd() throws Exception {
		MultipleAddressBook map = new MultipleAddressBook();
		try {

			System.out.println("Enter Number of contacts to Add");
			int a = sc.nextInt();
			for (int i = 1; i <= a; i++) {
				addingContacts();
			}
		} catch (Exception e) {
			System.out.println("Please Enter Valind number");
		}

	}
}
