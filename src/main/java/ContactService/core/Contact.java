package ContactService.core;

public class Contact {
	private String contactId = "";
	private String firstName = "";
	private String lastName = "";
	private String phoneNumber = "";
	private String contactAddress = "";
	
	// Constructors
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String contactAddress) {
		if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contactId. It must be a non-null string of up to 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName. It must be a non-null string of up to 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName. It must be a non-null string of up to 10 characters.");
        }
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number. It must be a non-null string of exactly 10 digits.");
        }
        if (contactAddress == null || contactAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid address. It must be a non-null string of up to 30 characters.");
        }
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.contactAddress = contactAddress;
	}
	
	// Setters
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
    		System.out.println("Invalid firstName. It must be a non-null string of up to 10 characters.");
    	} else {
    		this.firstName = firstName;
    	}
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
    		System.out.println("Invalid lastName. It must be a non-null string of up to 10 characters.");
    	} else {
    		this.lastName = lastName;
    	}
	}
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() > 10) {
    		System.out.println("Invalid phoneNumber. It must be a non-null string of exactly 10 digits.");
    	} else {
    		this.phoneNumber = phoneNumber;
    	}
	}
	public void setContactAddress(String contactAddress) {
		if (contactAddress == null || contactAddress.length() > 10) {
    		System.out.println("Invalid contactAddress. It must be a non-null string of up to 30 characters.");
    	} else {
    		this.contactAddress = contactAddress;
    	}
	}
	
	//Getters
	public String getContactId() {
		return this.contactId;
	}
	public String getFirstName(String contactId) {
		return this.firstName;
	}
	public String getLastName(String contactId) {
		return this.lastName;
	}
	public String getPhoneNumber(String contactId) {
		return this.phoneNumber;
	}
	public String getContactAddress(String contactId) {
		return this.contactAddress;
	}
}
