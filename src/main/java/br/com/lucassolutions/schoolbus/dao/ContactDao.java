package br.com.lucassolutions.schoolbus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Contact;
import br.com.lucassolutions.schoolbus.model.ContactStatus;

@Repository
public class ContactDao extends HibernateGenericDao<Contact> {
	
	private static final String WHATEVER = "%";

	public ContactDao(){
		super(Contact.class);
	}

	public List<Contact> findByContactWithLike(String contactName) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
			Restrictions.ilike("name", contactName + WHATEVER)));
		return findByCriterion(criterions);
	}
	
	public void updateStatus(Long contactId,ContactStatus contactStatus) {
		Contact contact = findById(contactId);
		contact.setStatus(contactStatus);
		update(contact);
	}
}
