package ContactService.test;

import ContactService.core.Contact;
import ContactService.core.ContactService;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
	private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }
    
    @After
    public void tearDown() {
    	service = null;
    }

    @Test
    public void testContactListCreation() {
    	assertEquals(0, service.getContactList().size()); // The contact list should now be size 0
    }
    
    // Testing Contact addition method
    @Test
    public void testValidContactListAddition() {
    	Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St.");
    	
        service.addContact(contact);
        
        assertEquals(1, service.getContactList().size()); // The contact list should now be size 1
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("2", "Jane", "Smith", "9876543210", "456 Elm St.");
        Contact contact2 = new Contact("2", "Janet", "Johnson", "5555555555", "789 Oak St.");

        service.addContact(contact1);
        service.addContact(contact2);
    }
    
    // Testing Contact deletion method
    @Test
    public void testValidContactDeletion() {
    	Contact contact1 = new Contact("2", "Jane", "Smith", "9876543210", "456 Elm St.");
        Contact contact2 = new Contact("3", "Janet", "Johnson", "5555555555", "789 Oak St.");

        service.addContact(contact1);
        service.addContact(contact2);
        
        service.deleteContact(contact1.getContactId());

        assertEquals(1, service.getContactList().size()); // Only one contact should be left
        assertEquals("3", service.getContactList().get(0).getContactId()); // The final contact's Id should be 3
    }
    
    @Test
    public void testInvalidContactDeletion() {
    	Contact contact1 = new Contact("2", "Jane", "Smith", "9876543210", "456 Elm St.");

        service.addContact(contact1);
        
        service.deleteContact("3");
    }
    
    // Testing Contact update method
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactId() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Contact Id", "1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistingContactId() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("2", "First Name", "Jane");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactNullContactId() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Contact Id", null);
    }
    
    @Test
    public void testUpdateValidContactFirstName() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "First Name", "Bobby");
        Contact updatedContact = service.getContactList().get(0);
        assertEquals("Bobby", updatedContact.getFirstName(updatedContact.getContactId())); // The contact's name should now be Bobby instead of Bob
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactNullFirstName() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "First Name", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactFirstNameLength() {
        Contact contact = new Contact("1", "abcdefghijklmnopqrstuvwxyz", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
    }
    
    @Test
    public void testUpdateValidContactLastName() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Last Name", "Brownie");
        Contact updatedContact = service.getContactList().get(0);
        assertEquals("Brownie", updatedContact.getLastName(updatedContact.getContactId())); // The contact's name should now be Brownie instead of Brown
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactNullLastName() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Last Name", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactLastNameLength() {
        Contact contact = new Contact("1", "John", "abcdefghijklmnopqrstuvwxyz", "1234567890", "123 Main St");
        service.addContact(contact);
    }
    
    @Test
    public void testUpdateValidContactPhoneNumber() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Phone Number", "3216549870");
        Contact updatedContact = service.getContactList().get(0);
        assertEquals("3216549870", updatedContact.getPhoneNumber(updatedContact.getContactId())); // The contact's number should now be 3216549870 instead of 9999999999
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactNullPhoneNumber() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Phone Number", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactPhoneNumberLength() {
        Contact contact = new Contact("1", "John", "Doe", "12345678901234", "123 Main St");
        service.addContact(contact);
    }
    
    @Test
    public void testUpdateValidContactContactAddress() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Contact Address", "689 Damsel Rd");
        Contact updatedContact = service.getContactList().get(0);
        assertEquals("689 Damsel Rd", updatedContact.getContactAddress(updatedContact.getContactId())); // The contact's address should now be 689 Damsel Rd instead of 567 Willow St
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactNullContactAddress() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Contact Address", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactContactAddressLength() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "1234567890 Westminster College Street");
        service.addContact(contact);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidContactField() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);
        service.updateContact("4", "Contact's First Name", "Bobby");
    }
}
