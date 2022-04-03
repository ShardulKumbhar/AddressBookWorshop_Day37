import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAddressBook {

	@Test
	public void printWellComeMessage() {
		System.out.println("Well-come to address book testing");
	}

	@Test
	public void toCheckContacts() {
		AddressBookServer addressBook = new AddressBookServer();
		addressBook.checkDublicate();
		int output = addressBook.getContacts();
		Assert.assertEquals(1, output);
	}
}
