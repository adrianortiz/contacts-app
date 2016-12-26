package com.codizer.service;

import java.util.List;

import com.codizer.model.ContactModel;

public interface ConctactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
}
