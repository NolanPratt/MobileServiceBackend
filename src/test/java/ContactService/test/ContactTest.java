package ContactService.test;

import ContactService.core.Contact;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
	private Contact contact;

    @Before
    public void setUp() {
        contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
    }
    
    @After
    public void tearDown() {
    	contact = null;
    }

    // Testing valid Contact definitions
    @Test
    public void testValidContactCreation() {
        assertNotNull(contact);
    }

    @Test
    public void testValidContactId() {
        assertEquals("1", contact.getContactId());
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

    // Testing null attributes
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNullContactCreation() {
        new Contact(null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationWithoutId() {
        new Contact(null, "Joe", "Doe", "1234567890", "123 Main St");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationWithoutFirstName() {
        new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationWithoutLastName() {
        new Contact("1234567890", "Joe", null, "1234567890", "123 Main St");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationWithoutPhoneNumber() {
        new Contact("1234567890", "Joe", "Doe", null, "123 Main St");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationWithoutContactAddress() {
        new Contact("1234567890", "Joe", "Doe", "1234567890", null);
    }
    
    // Testing satisfaction of attribute requirements
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationIdLength() {
        new Contact("12345678901234", "Joe", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationFirstNameLength() {
        new Contact("1", "abcdefghijklmnopqrstuvwxyz", "Doe", "1234567890", "123 Main St");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactFirstNameLength() {
        contact.setFirstName("abcdefghijklmnopqrstuvwxyz");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactNullFirstName() {
        contact.setFirstName(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationLastNameLength() {
        new Contact("1", "Joe", "abcdefghijklmnopqrstuvwxyz", "1234567890", "123 Main St");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactLastNameLength() {
        contact.setLastName("abcdefghijklmnopqrstuvwxyz");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactNullLastName() {
        contact.setLastName(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationPhoneNumberLength() {
        new Contact("1", "Joe", "Doe", "12345678901234", "123 Main St");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactPhoneNumberLength() {
        contact.setPhoneNumber("12345678901234");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactNullPhoneNumber() {
        contact.setPhoneNumber(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactCreationContactAddressLength() {
        new Contact("1", "Joe", "Doe", "12345678901234", "1234567890 Westminster College Street");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactContactAddressLength() {
        contact.setContactAddress("1234567890 Westminster College Street");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidContactNullContactAddress() {
        contact.setContactAddress(null);
    }
}