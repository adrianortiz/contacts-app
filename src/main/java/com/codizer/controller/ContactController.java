package com.codizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codizer.contact.ViewConstant;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@GetMapping("/contactform")
	public String redirectContactForm() {
		return ViewConstant.CONTACT_FORM;
	}

}
