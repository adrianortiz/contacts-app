package com.codizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codizer.model.ContactModel;
import com.codizer.service.impl.ContactServiceImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactServiceImpl contactServiceImpl;
	
	@GetMapping("/checkrest")
	public ResponseEntity<String> checkRest() {
		return new ResponseEntity<String>("OK!", HttpStatus.OK);
	}
	
	@GetMapping("/checkrest2")
	public ResponseEntity<ContactModel> checkRest2() {
		ContactModel cm = new ContactModel(2, "Mike", "Smith", "23342378", "México");
		return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
	}
	
	@GetMapping("/listContacts")
	public ResponseEntity<List<ContactModel>> listContacts() {
		List<ContactModel> contacts = contactServiceImpl.listAllContacts();
		return new ResponseEntity<List<ContactModel>>(contacts, HttpStatus.OK);
	}
}
