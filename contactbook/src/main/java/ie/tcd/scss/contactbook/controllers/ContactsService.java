package ie.tcd.scss.contactbook.services;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
// @Service marks this class as a Spring service component.
@Service
public class ContactsService {
	// Using a HashMap as a simple in-memory database.
	private final Map<String, String> contacts = new HashMap<>();
	// Constructor to pre-populate the map with some data.
	public ContactsService() {
		contacts.put("Peter", "0861234567");
		contacts.put("Mary", "0851111333");
	}
	// Method to return all contacts.
	public Map<String, String> getAllContacts() {
		return contacts;
	}
	// Method to retrieve a phone number by name.
	public String getPhoneNumber(String name) {
		return contacts.get(name);
	}
	// Method to add or update a contact.
	public void addContact(String name, String phone) {
		contacts.put(name, phone);
	}
	// Method to delete a contact.
	public void deleteContact(String name) {
		contacts.remove(name);
	}
}
