package com.codizer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codizer.contact.ViewConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	/**
	 * Show login form.
	 *
	 * @param error the error
	 * @param logout the logout
	 * @return the model and view
	 */
	@GetMapping("/login")
	public ModelAndView showLoginForm (
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);
		ModelAndView mav = new ModelAndView(ViewConstant.LOGIN);
		mav.addObject("error", error);
		mav.addObject("logout", logout);
		LOG.info("RETURN VIEW: login");
		return mav;
	}
	
	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		LOG.info("METHOD: loginCheck()");
		LOG.info("Returning to contacts view");
		return "redirect:/contacts/showcontacts";
	}
}
