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

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ConctactService {

	/** The contact reporitory. */
	@Autowired
	@Qualifier("contactRepository")
	private ContactReporitory contactReporitory;
	
	/** The contact converter. */
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	/* (non-Javadoc)
	 * @see com.codizer.service.ConctactService#addContact(com.codizer.model.ContactModel)
	 */
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactReporitory.save(contactConverter.converterContactModel2Contact(contactModel));
		return contactConverter.converterContact2ContactModel(contact);
	}

	/* (non-Javadoc)
	 * @see com.codizer.service.ConctactService#listAllContacts()
	 */
	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactReporitory.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.converterContact2ContactModel(contact));
		}
		return contactsModel;
	}

	/* (non-Javadoc)
	 * @see com.codizer.service.ConctactService#findContactById(int)
	 */
	@Override
	public Contact findContactById(int id) {
		return contactReporitory.findById(id);
	}
	

	/* (non-Javadoc)
	 * @see com.codizer.service.ConctactService#removeContact(int)
	 */
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if (null != contact) {
			contactReporitory.delete(contact);
		}
	}

	/* (non-Javadoc)
	 * @see com.codizer.service.ConctactService#findContactByIdModel(int)
	 */
	@Override
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.converterContact2ContactModel(findContactById(id));
	}

}
