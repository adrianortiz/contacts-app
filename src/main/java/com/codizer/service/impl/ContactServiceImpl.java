package com.codizer.service.impl;

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
	private ContactReporitory conctactService;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = conctactService.save(contactConverter.converterContactModel2Contact(contactModel));
		return contactConverter.converterContact2ContactModel(contact);
	}

}
