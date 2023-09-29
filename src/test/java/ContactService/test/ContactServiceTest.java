package ContactService.test;

import ContactService.core.Contact;
import ContactService.core.ContactService;
import TaskService.core.Task;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
	private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testContactListCreation() {
    	assertEquals(0, service.getContactList().size()); // The contact list should now be size 0
    }
    
    @Test
    public void testContactListAddition() {
    	Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St.");
    	
        service.addContact(contact);
        
        assertEquals(1, service.getContactList().size()); // The contact list should now be size 1
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("2", "Jane", "Smith", "9876543210", "456 Elm St.");
        Contact contact2 = new Contact("2", "Janet", "Johnson", "5555555555", "789 Oak St.");

        service.addContact(contact1);
        service.addContact(contact2);

        assertEquals(1, service.getContactList().size()); // Only one contact should be added
    }
    
    @Test
    public void testDeleteContact() {
    	Contact contact1 = new Contact("2", "Jane", "Smith", "9876543210", "456 Elm St.");
        Contact contact2 = new Contact("3", "Janet", "Johnson", "5555555555", "789 Oak St.");

        service.addContact(contact1);
        service.addContact(contact2);
        
        service.deleteContact(contact1.getContactId());

        assertEquals(1, service.getContactList().size()); // Only one contact should be left
        assertEquals("3", service.getContactList().get(0).getContactId()); // The final contact's Id should be 3
    }
    
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("4", "Bob", "Brown", "9999999999", "567 Willow St.");
        service.addContact(contact);

        // Update the contact's first name
        service.updateContact("4", "First Name", "Bobby");

        Contact updatedContact = service.getContactList().get(0);
        assertEquals("Bobby", updatedContact.getFirstName(updatedContact.getContactId())); // The contact's name should now be Bobby instead of Bob
    }
}
