package br.com.lucassolutions.schoolbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucassolutions.schoolbus.facade.FacadeStudent;
import br.com.lucassolutions.schoolbus.model.Period;
import br.com.lucassolutions.schoolbus.model.School;

@Controller
@RequestMapping("/controller/user")
public class StudentController {
	
	private static final String REGISTER_STUDENT_VIEW = "registerStudent";
	
	@Autowired private FacadeStudent facadeStudent;
	
	@RequestMapping("/registerStudentView")
	public String registerView(ModelMap model){
		List<School> schools = facadeStudent.getSchools();
		model.addAttribute("listSchool", schools);
		model.addAttribute("periods", Period.values());
		return REGISTER_STUDENT_VIEW;
	}
	
}