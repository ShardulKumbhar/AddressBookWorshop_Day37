import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import addressbookworkshop.AddressBookServer;

public class TestAddressBook {

	@Test
	public void printWellComeMessage() {
		System.out.println("Well-come to address book testing");
	}

	@Test
	public void test() throws Exception {
		AddressBookServer addressBookserver = new AddressBookServer();
		addressBookserver.checkForDuplicate();
		int output = addressBookserver.length();
		Assert.assertEquals(1, output);
	}
}
