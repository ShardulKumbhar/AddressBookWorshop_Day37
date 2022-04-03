package addressbookworkshop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddressBookServer {
	/*
	 * Creating objects and arrayList
	 */
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> contact = new ArrayList<Person>();
	static Person person;
	static AddressBookServer addressBook = new AddressBookServer();

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

	/*
	 * Checking for duplicate value
	 */
	public String checkForDuplicate() throws Exception {
		System.out.println("Enter First Name: ");
		String name = sc.next();
		if (name.matches("[A-z]{1}[a-z]{2,}")) {
		} else {
			System.out.println("Please Enter only Alphabets start with capital letter for name..");
			addressBook.checkForDuplicate();
		}
		if (contact.size() > 0) {
			for (Person personList : contact) {
				person = personList;
				if (name.equals(person.firstName)) {
					System.out.println(
							"Person with name : " + person.firstName + " already exists...\nPlease enter again..");
					addressBook.checkForDuplicate();

				} else {
					addressBook.addContact(name);
				}
			}
		} else {
			addressBook.addContact(name);
		}
		return name;
	}

	/*
	 * Adding Contacts in contact and validating all the inputs given by user
	 * using @REGEX
	 */
	public Person addContact(String name) {
		while (true) {
			String firstName = name;
			if (firstName.matches(namePattern)) {
			} else {
				System.out.println("Please Enter Valid First Name");
				System.exit(0);
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
			contact.add(person);
			System.out.println(person);
			return person;
		}
	}

	/*
	 * Getting Length of contact
	 */
	public Integer length() {
		int a = addressBook.contact.size();
		return a;
	}

	/*
	 * Editing contacts by firstName
	 */
	public static void editDetails() throws Exception {
		System.out.println("Enter first name: ");
		String fname = sc.next();
		for (int i = 0; i < contact.size(); i++) {
			if (contact.get(i).getFirstName().equals(fname)) {
				System.out.println(contact.get(i));
				System.out.println(
						"Enter your choice to edit....\n1. FirstName\n2. LastName\n3. Address\n4. City\n5. State\n6. Zipcode\n7. PhoneNumber\n8. Email\n");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter new FirstName: ");
					String new_first_name = sc.next();
					contact.get(i).setFirstName(new_first_name);

					break;
				case 2:
					System.out.println("Enter new LastName: ");
					String new_last_name = sc.next();
					contact.get(i).setLastName(new_last_name);

					break;
				case 3:
					System.out.println("Enter new Address: ");
					String new_address = sc.next();
					contact.get(i).setAddress(new_address);

					break;
				case 4:
					System.out.println("Enter new City Name: ");
					String new_city = sc.next();
					contact.get(i).setCity(new_city);

					break;
				case 5:
					System.out.println("Enter new State Name: ");
					String new_state = sc.next();
					contact.get(i).setState(new_state);

					break;
				case 6:
					System.out.println("Enter new Zip code: ");

					String new_zip = sc.next();
					contact.get(i).setZip(new_zip);

					break;
				case 7:
					System.out.println("Enter new Phone Number: ");
					String new_phno = sc.next();
					contact.get(i).setPhno(new_phno);

					break;
				case 8:
					System.out.println("Enter new email Id: ");
					String new_emailId = sc.next();
					contact.get(i).setEmailId(new_emailId);

					break;
				default:
					System.out.println("Enter a valid choice");
					break;
				}
			} else {
				System.out.println("No Person Exist by this name...");
			}
		}
		System.out.println(contact);
	}

	/*
	 * To Delete any contacts
	 */
	public void deleteContact() throws Exception {
		System.out.print("Enter the first name to delete: ");
		String dName = sc.next();
		if (contact.size() > 0) {
			for (int i = 0; i < contact.size(); i++) {
				if (contact.get(i).getFirstName().equalsIgnoreCase(dName)) {
					contact.remove(i);
					System.out.println("Contact deleted...");
					System.out.println(contact);
					break;
				}
			}
			System.out.println("...Contact not found!!!\n");
		} else {
			System.out.println("***Empty AddressBook***");
		}
	}

	/*
	 * To Find Contacts by name
	 */
	public void findContact() throws Exception {
		System.out.println("Enter the first name: ");
		String fName = sc.next();
		if (contact.size() > 0) {
			for (int i = 0; i <= contact.size(); i++) {
				if (contact.get(i).getFirstName().equalsIgnoreCase(fName)) {
					System.out.println("Here is the Contact you are looking for :- \n" + contact.get(i));
					break;
				}
			}
			System.out.println("...Contact not found!!!\n");
		} else {
			System.out.println("***Empty AddressBook***");
		}
	}

}