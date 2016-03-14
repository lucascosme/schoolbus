package br.com.lucassolutions.schoolbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.facade.SchoolFacade;

@Controller
@RequestMapping("/controller/user")
public class SchoolController {

	@Autowired SchoolFacade schoolFacade;
	
	@RequestMapping("/saveSchoolView")
	public String saveSchoolView(){
		return "registerSchool";
	}
	
	@RequestMapping("/saveSchool")
	public String saveSchool(ModelMap model,@RequestParam("school") String schoolName,
			@RequestParam("telephone") String telephone,@RequestParam("directorName") String directorName,
			@RequestParam("street") String street,@RequestParam("neighborhood") String neighborhood,
			@RequestParam("city") String city){
		schoolFacade.saveSchool(schoolName,telephone,directorName,street,neighborhood,city);
		return saveSchoolView();
	}
}