package br.com.lucassolutions.schoolbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.ContactDao;
import br.com.lucassolutions.schoolbus.model.Contact;

@Service
public class ContactService {
	
	@Autowired private ContactDao contactDao;

	public List<Contact> demandContact(String contactName) {
		return contactDao.findByContactWithLike(contactName);
		
	}

	public void saveContact(String contactName, String site, String email, String telephone, String celphone,
			String address, String neighborhood, String city, String state) {
		
		Contact contact = new Contact();
		contact.setName(contactName);
		contact.setSite(site);
		contact.setEmail(email);
		contact.setTelephone(telephone);
		contact.setCelphone(celphone);
		contact.setAddress(address);
		contact.setNeighborhood(neighborhood);
		contact.setCity(city);
		contact.setState(state);
		contactDao.save(contact);
	}

	public List<Contact> getContacts() {
		return contactDao.findAll();
	}

	public void desableContact(Long contactId) {
		// TODO Auto-generated method stub
		
	}

}
