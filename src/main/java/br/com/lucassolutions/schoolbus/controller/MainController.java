package br.com.lucassolutions.schoolbus.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	private static final String LOGIN_PAGE = "login";
	private static final String NOT_FOUND_PAGE = "404";
	private static final String ACCESS_DENIED_PAGE = "403";

	private static final String HOME_PAGE = "redirect:controller/user/home";

	@RequestMapping(value = "/")
	public String home() {
		return HOME_PAGE;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("errorMessage", "Invalid username or password. Please try again!");
		}
		model.setViewName(LOGIN_PAGE);
		return model;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName(ACCESS_DENIED_PAGE);
		return model;
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String pageNotFound() {
		return NOT_FOUND_PAGE;
	}
}