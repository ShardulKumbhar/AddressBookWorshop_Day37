package addressbookworkshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAddressBookSystemToRun {

	public static void main(String[] args) throws Exception {
		MultipleAddressBook multiAddressBook = new MultipleAddressBook();
		AddressBookServer addressBookServer = new AddressBookServer();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Address Book Program in AddressBook Main Class");
		try {
			while (true) {
				System.out.println(
						"Enter choice...\n1. Add new contact in AddressBook\n2. Edit existing details\n3. Delete existing details\n4. Find contact by name"
								+ "\n .................."
								+ "\n5. Add AddressBook \n6: Add Contact in AddressBook \n7: Display AddressBook \n8 :search by state \n9 :serch by city");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the no of contacts want to add : ");
					int a = sc.nextInt();
					for (int i = 1; i <= a; i++) {
						addressBookServer.checkForDuplicate();
					}
					break;
				case 2:
					if (AddressBookServer.contact.isEmpty()) {
						System.out.println("Address Book is empty..!!");
					} else {
						AddressBookServer.editDetails();
						break;
					}
				case 3:
					if (AddressBookServer.contact.isEmpty()) {
						System.out.println("Address Book is empty");
						break;
					} else {
						addressBookServer.deleteContact();
					}
					break;
				case 4:
					if (AddressBookServer.contact.isEmpty()) {
						System.out.println("Address Book is empty");
						break;
					} else {
						addressBookServer.findContact();
					}
					break;
				case 5:
					multiAddressBook.AddMultipleAddressBook();
					break;
				case 6:
					multiAddressBook.noOfContactsToAdd();
					break;
				case 7:
					multiAddressBook.displayBook();
					break;
				case 8:
					multiAddressBook.searchByState();
					break;
				case 9:
					multiAddressBook.searchByCity();
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");

		}
	}

}