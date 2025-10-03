package ie.tcd.scss.contactbook.controllers;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ie.tcd.scss.contactbook.services.ContactsService;
// @RestController combines @Controller and @ResponseBody, making it easy to create RESTful web services.
@RestController
public class ContactsController {
	// @Autowired tells Spring to automatically inject an instance of ContactsService here.
	@Autowired
	private ContactsService contactsService;
	// Maps HTTP GET requests for "/contacts" to list all contacts.
	@GetMapping("/contacts")
	public Map<String, String> getAllContacts() {
		return contactsService.getAllContacts();
	}
	// Maps HTTP GET requests for "/contacts/{name}" to find a specific contact.
	// The {name} part is a path variable.
	@GetMapping("/contacts/{name}")
	public String getContact(@PathVariable String name) {
		String phoneNumber = contactsService.getPhoneNumber(name);
		return phoneNumber != null ? phoneNumber : "Contact not found.";
	}
	// Maps HTTP POST requests for "/contacts" to add a new contact.
	// Request parameters are used to pass the name and phone number.
	@PostMapping("/contacts")
	public String addContact(@RequestParam String name, @RequestParam String phone) {
		contactsService.addContact(name, phone);
		return "Contact for " + name + " added.";
	}
	// Maps HTTP DELETE requests for "/contacts/{name}" to delete a contact.
	@DeleteMapping("/contacts/{name}")
	public String deleteContact(@PathVariable String name) {
		contactsService.deleteContact(name);
		return "Contact for " + name + " deleted.";
	}
}
