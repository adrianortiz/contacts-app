package com.codizer.service;

import java.util.List;

import com.codizer.entity.Contact;
import com.codizer.model.ContactModel;

public interface ConctactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactByIdModel(int id);
}
