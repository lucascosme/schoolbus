package br.com.lucassolutions.schoolbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/controller/user")
public class HomeController {

	private static final String HOME = "home";
	
	@RequestMapping("/home")
	public String view() {
		return HOME;
	}
	
}