package com.codizer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codizer.component.ContactConverter;
import com.codizer.entity.Contact;
import com.codizer.model.ContactModel;
import com.codizer.repository.ContactReporitory;
import com.codizer.service.ConctactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ConctactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactReporitory contactReporitory;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactReporitory.save(contactConverter.converterContactModel2Contact(contactModel));
		return contactConverter.converterContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactReporitory.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.converterContact2ContactModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactReporitory.findById(id);
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if (null != contact) {
			contactReporitory.delete(contact);
		}
	}

}
