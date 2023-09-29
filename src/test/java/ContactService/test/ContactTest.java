package ContactService.test;

import ContactService.core.Contact;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
	private Contact contact;

    @Before
    public void setUp() {
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testValidContactCreation() {
        assertNotNull(contact);
    }

    @Test
    public void testValidFirstName() {
        assertEquals("John", contact.getFirstName(contact.getContactId()));
    }

    @Test
    public void testValidLastName() {
        assertEquals("Doe", contact.getLastName(contact.getContactId()));
    }

    @Test
    public void testValidPhoneNumber() {
        assertEquals("1234567890", contact.getPhoneNumber(contact.getContactId()));
    }

    @Test
    public void testValidAddress() {
        assertEquals("123 Main St", contact.getContactAddress(contact.getContactId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactID() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
    }
}