package addressbookworkshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddressBook {
	/**
	 * Procedure ========================================== 1.created arrayList
	 * 2.Method to add Contacts 3.method to editDetails 4.
	 * ==========================================
	 */

	/*
	 * 1.created arrayList created scanner class to take user input creating
	 * 
	 */
	static Scanner sc = new Scanner(System.in);
	static List<Person> list = new ArrayList<Person>();
	static Person person;
	static AddressBook addressBook = new AddressBook();
	/*
	 * regex to validate input from user
	 */

	private static final String namePattern = "^[A-Z]{1}[a-z]{2,}$";
	private static final String emailPattern = "^[a-z0-9]{3,}+([_+-.][a-z0-9]{3,}+)*@[a-z0-9]+.[a-z]{2,3}+(.[a-z]{2,3}){0,1}$";
	private static final String addressPattern = "^[A-Za-z0-9]{5,}$";
	private static final String cityPattern = "^[A-Za-z]{2,}$";
	private static final String statePattern = "^[A-Za-z]{2,}$";
	private static final String zipPattern = "^[0-9]{6}$";
	private static final String phonePattern = "^[0-9]{10}$";
	private static final String passwordPattern = "^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$";

	/*
	 * checking dublicate first name
	 */
	public void checkDublicate() throws Exception {
		System.out.println("Enter First Name: ");
		String name = sc.next();

		try {
			if (list.size() > 0) {
				for (Person personList : list) {
					person = personList;

					/*
					 * checking first name already exists or not
					 */
					if (name.equals(person.firstName)) {
						System.out.println("Person with name : " + person.firstName + " already exists......");
						addressBook.checkDublicate();
					} else {
						addressBook.addContact(name);
					}
				}

			} else {
				addressBook.addContact(name);
			}
		} catch (NullPointerException e) {
			System.out.println(e);

		}
	}

	/*
	 * 2. Method to add Contacts Adding contacts with user name
	 * 
	 * checking first name already exists or not If first name is not exist then
	 * adding all contacts
	 */
	public void addContact(String name) throws Exception {
		try {
			String firstName = name;
			if (firstName.matches(namePattern)) {
			} else {
				System.out.println("Please Enter Valid First Name");
				addressBook.checkDublicate();
			}

			System.out.println("Enter Last Name: ");
			String lastName = sc.next();
			if (lastName.matches(namePattern)) {
			} else {
				System.out.println("Please Enter Valid Last Name \nPlease Refresh...");
				System.exit(0);
			}

			System.out.println("Enter Address: ");
			String address = sc.next();
			if (address.matches(addressPattern)) {
			} else {
				System.out.println("Please Enter Valid Address \nPlease Refresh...");
				System.exit(0);
			}

			System.out.println("Enter City Name: ");
			String city = sc.next();
			if (city.matches(cityPattern)) {
			} else {
				System.out.println("Please Enter Valid city Name \nPlease Refresh...");
				System.exit(0);
			}

			System.out.println("Enter State Name: ");
			String state = sc.next();
			if (state.matches(statePattern)) {
			} else {
				System.out.println("Please Enter Valid State Name \nPlease Refresh...");
				System.exit(0);
			}

			System.out.println("Enter Zip code: ");
			String zip = sc.next();
			if (zip.matches(zipPattern)) {
			} else {
				System.out.println("Please Enter Valid zip code ex.416552 \nPlease Refresh...");
				System.exit(0);
			}

			System.out.println("Enter Phone Number: ");
			String phno = sc.next();
			if (phno.matches(phonePattern)) {
			} else {
				System.out.println("Please Enter Valid 10 digit PhoneNumber \nPlease Refresh...");
				System.exit(0);
			}
			System.out.println("Enter email address: ");
			String emailId = sc.next();
			if (emailId.matches(emailPattern)) {
			} else {
				System.out.println("Please Enter Valid Email Address ex.abc-100@yahoo.com \nPlease Refresh...");
				System.exit(0);
			}

			person = new Person(firstName, lastName, address, city, state, zip, phno, emailId);
			list.add(person);
			System.out.println(list);
		} catch (InputMismatchException e) {
			System.out.println("Please Enter the valid input");

		}
	}

	/*
	 * 3.method to editDetails looping in Arraylist checking first name is equal as
	 * given name for edit
	 * 
	 */
	public void editDetails() throws Exception {
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

	/*
	 * method to delete contacts
	 */
	public void deleteContact() throws Exception {

		System.out.println("Enter the first name to Delete");
		String dname = sc.next();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				for (Person personList : list) {

					if (list.get(i).getFirstName().equalsIgnoreCase(dname)) {
						list.remove(i);
						System.out.println("Contacts removed successfully");
						System.out.println(list);
						break;
					}
				}
			}
		} else {
			System.out.println("Match not found");
		}

	}

	public static void main(String[] args) throws Exception {
		/**
		 * 1.created object of class 2.creating a user choice to add or edit contacts
		 * 3.Checking Arraylist is empty of not 4.deleting contacts
		 */

		/*
		 * 1.created object of class
		 */

		AddressBook addressBook = new AddressBook();
		System.out.println("Welcome to Address Book Program in AddressBook Main Class");

		/*
		 * 2.creating a user choice to add or edit contacts
		 */
		try {
			while (true) {
				System.out.println("Enter choice...\n1 :Add Contact \n2 : Edit Details \n3 :Delete by Name");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter Number of contacts to Add");
					int a = sc.nextInt();
					for (int i = 1; i <= a; i++) {
						addressBook.checkDublicate();
					}
					break;
				case 2:
					if (AddressBook.list.isEmpty()) {
						System.out.println("Address Book is empty..!!");
						break;
					} else {
						addressBook.editDetails();
					}
					break;
				case 3:
					addressBook.deleteContact();
					break;

				default: {
					System.out.println("Enter a correct choice");
				}
				}
			}
		} catch (Exception e) {
			System.out.println();
		}
	}

}