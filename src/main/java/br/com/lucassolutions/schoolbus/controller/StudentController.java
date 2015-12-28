package br.com.lucassolutions.schoolbus.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.dao.SchoolDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.facade.StudentFacade;
import br.com.lucassolutions.schoolbus.model.Period;
import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;

@Controller
@RequestMapping("/controller/user")
public class StudentController {
	
	private static final String REGISTER_STUDENT_VIEW = "registerStudent";
	
	@Autowired private StudentFacade studentfacade;
	@Autowired private StudentDao studentDao;
	@Autowired private SchoolDao schoolDao;
	
	@RequestMapping("/registerStudentView")
	public String registerView(ModelMap model){
		List<School> schools = studentfacade.getSchools();
		model.addAttribute("listSchool", schools);
		model.addAttribute("periods", Period.values());
		return REGISTER_STUDENT_VIEW;
	}
	
	@RequestMapping("/saveStudent")
	public String saveStudent(ModelMap model,
			@RequestParam("name")String name,
			@RequestParam("responsibleName")String responsibleName,
			@RequestParam("telephone")String telephone,
			@RequestParam("schools")Long schools,
			@RequestParam("period")String period,
			@RequestParam("paymentDate")LocalDate paymentDate,
			@RequestParam("valuePayment")Double valuePayment){
		
		School idSchool = schoolDao.findById(schools);
		
		Student student = new Student();
		student.setName(name);
		student.setResponsibleName(responsibleName);
		student.setTelephone(telephone);
		student.setSchool(idSchool);
		student.setPeriod(period);
		student.setPaymentDate(paymentDate);
		student.setValuePayment(valuePayment);
		
		studentDao.save(student);
		
		
		model.addAttribute("sucess", "Aluno salvo com sucesso!");
		return registerView(model);
	}
	
}