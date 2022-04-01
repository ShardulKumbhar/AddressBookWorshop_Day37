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
	 * 3.method to editDetails
	 * ==========================================
	 */

	/*
	 * 1.created arrayList created scanner class to take user input creating
	 * 
	 */
	static Scanner sc = new Scanner(System.in);
	static List<Person> list = new ArrayList<Person>();
	static Person person;

	/*
	 * 2. Method to add Contacts Adding contacts with user name
	 * 
	 * checking first name already exists or not
	 * If first name is not  exist then  adding all contacts 
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
		if (list.size() > 0) {
			for (Person personList : list) {
				person = personList;

				/*
				 * checking first name already exists or not
				 */
				if (firstName.equals(person.firstName)) {
					System.out.println("Person with name : " + person.firstName + " already exists......");
					break;
				}
			}
		} else {
			/*
			 * If first name is not same the adding all contacts 
			 */
			person = new Person(firstName, lastName, address, city, state, zip, phno, emailId);
			list.add(person);
			System.out.println(list);
		}
	}

	/*
	 * 3.method to editDetails
	 * looping in Arraylist
	 * checking first name is equal as given name for edit
	 * 
	 */
	public void editDetails() {
		System.out.println("Enter first name: ");
		String fname = sc.next();
		/*
		 * looping in Arraylist
		 */
		for (int i = 0; i < list.size(); i++) {
			/*
			 * checking first name is equal as given name for edit
			 */
			if (list.get(i).getFirstName().equals(fname)) {
				System.out.println(list.get(i));
				System.out.println(
						"Enter your choice to edit....\n1. FirstName\n2. LastName\n3. Address\n4. City\n5. State\n6. Zipcode\n7. PhoneNumber\n8. Email\n");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter new FirstName: ");
					String new_first_name = sc.next();
					list.get(i).setFirstName(new_first_name);
					System.out.println(list.get(i).getFirstName());
					break;
				case 2:
					System.out.println("Enter new LastName: ");
					String new_last_name = sc.next();
					list.get(i).setLastName(new_last_name);
					System.out.println(list.get(i).getLastName());
					break;
				case 3:
					System.out.println("Enter new Address: ");
					String new_address = sc.next();
					list.get(i).setAddress(new_address);
					System.out.println(list.get(i).getAddress());
					break;
				case 4:
					System.out.println("Enter new City Name: ");
					String new_city = sc.next();
					list.get(i).setCity(new_city);
					System.out.println(list.get(i).getCity());
					break;
				case 5:
					System.out.println("Enter new State Name: ");
					String new_state = sc.next();
					list.get(i).setState(new_state);
					System.out.println(list.get(i).getState());
					break;
				case 6:
					System.out.println("Enter new Zip code: ");
					String new_zip = sc.next();
					list.get(i).setZip(new_zip);
					System.out.println(list.get(i).getZip());
					break;
				case 7:
					System.out.println("Enter new Phone Number: ");
					String new_phno = sc.next();
					list.get(i).setPhno(new_phno);
					System.out.println(list.get(i).getPhno());
					break;
				case 8:
					System.out.println("Enter new email Id: ");
					String new_emailId = sc.next();
					list.get(i).setEmailId(new_emailId);
					System.out.println(list.get(i).getEmailId());
					break;
				default:
					System.out.println("Enter a valid choice");
					break;
				}
			}
		}
		System.out.println(list);
	}

	public static void main(String[] args) {
		/**
		 * 1.created object of class 
		 * 2.creating a user choice to add or edit contacts
		 * 3.Checking Arraylist is empty of not
		 */
		
		
		/*
		 * 1.created object of class 
		 */
		AddressBook addressBook = new AddressBook();
		System.out.println("Welcome to Address Book Program in AddressBook Main Class");

		/*
		 * 2.creating a user choice to add or edit contacts
		 */

		while (true) {
			System.out.println("Enter choice...\n1 :Add Contact \n2 : Edit Details");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				/*
				 * 3.Checking Arraylist is empty of not
				 */
				if (AddressBook.list.isEmpty()) {
					System.out.println("Address Book is empty..!!");
					break;
				} else {
					addressBook.editDetails();
					break;
				}
			}
		}
	}

}