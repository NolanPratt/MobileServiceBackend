package ContactService.core;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	private List<Contact> contactList = new ArrayList<>();
	
	// Constructor
	public ContactService() {
		
	}
	
	public List<Contact> getContactList() {
		return this.contactList;
	}
	
	// Add a new contact to the Contact list
	public void addContact(Contact contact) {
		if (contactExists(contact)) {
	        System.err.println("Error: Duplicate Contact. Contact with ID " + contact.getContactId() + " already exists.");
	        contact = null;
	    } else {
	        contactList.add(contact);
	    }
	}
	
	// Check whether a Contact already exists within the Contact list
	public boolean contactExists(Contact contact) {
		for (Contact contacts : contactList) {
			if (contact.getContactId().equals(contacts.getContactId())) {
				return true;
			}
		}
		return false;
	}
	
	// Iterate through the Contact list and delete the Contact object with a matching Id
	public void deleteContact(String contactId) {
		for (Contact contact : contactList) {
			if (contact.getContactId().equals(contactId)) {
				contactList.remove(contact);
			}
		}
	}
	
	// Update a Contact's specified field to a new value
	public void updateContact(String contactId, String fieldToUpdate, String newValue) {
		for (Contact contact : contactList) {
			if (contact.getContactId().equals(contactId)) {
				switch (fieldToUpdate) {
			    case "Contact Id":
			        System.out.println("Invalid Request: Contact Id is Immutable.");
			        break;
			    case "First Name":
			    	contact.setFirstName(newValue);
			    	System.out.println("Update Success: Contact First Name Changed.");
			        break;
			    case "Last Name":
			    	contact.setLastName(newValue);
			    	System.out.println("Update Success: Contact Last Name Changed.");
			        break;
			    case "Phone Number":
			    	contact.setPhoneNumber(newValue);
			    	System.out.println("Update Success: Contact Phone Number Changed.");
			        break;
			    case "Home Address":
			    	contact.setContactAddress(newValue);
			    	System.out.println("Update Success: Contact Home Address Changed.");
			        break;
			    default:
			        System.out.println("Invalid Field");
			        break;
				}
				break;
			}
		}
	}
}
