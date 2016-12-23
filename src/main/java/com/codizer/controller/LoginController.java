package com.codizer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codizer.model.UserCredential;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		LOG.info("REDIRECT VIEW: login");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public ModelAndView showLoginForm (
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("userCredentials", new UserCredential());
		mav.addObject("error", error);
		mav.addObject("logout", logout);
		LOG.info("RETURN VIEW: login");
		return mav;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential) {
		
		LOG.info("METHOD: loginCheck() -- PARAMS: '" + userCredential.toString() + "'");
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			LOG.info("RETURN VIEW: contacts");
			return "contacts";
		}
		LOG.info("REDIRECT VIRE: login?error");
		return "redirect:/login?error";
	}
}
