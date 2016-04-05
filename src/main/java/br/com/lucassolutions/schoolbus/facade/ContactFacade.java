package br.com.lucassolutions.schoolbus.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.Contact;
import br.com.lucassolutions.schoolbus.service.ContactService;

@Component
public class ContactFacade {
	
	@Autowired private ContactService contactService;

	public List<Contact> demandContact(String contactName) {
		return contactService.demandContact(contactName);
	}

	public void saveContact(String contactName, String site, String email, String telephone, String celphone,
			String address, String neighborhood, String city, String state) {
		contactService.saveContact(contactName,site,email,telephone,celphone,address,neighborhood,city,state);
	}

	public List<Contact> getContacts() {
		return contactService.getContacts();
	}

	public void disableContact(Long contactId) {
		contactService.desableContact(contactId);
	}

}
