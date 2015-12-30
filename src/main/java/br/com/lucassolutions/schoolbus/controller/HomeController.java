package br.com.lucassolutions.schoolbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucassolutions.schoolbus.dao.StudentDao;


@Controller
@RequestMapping("/controller/user")
public class HomeController {

	private static final String HOME = "home";
	
	@Autowired private StudentDao studentDao;
	
	@RequestMapping("/home")
	public String view() {
		return HOME;
	}
	
}