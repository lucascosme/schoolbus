package br.com.lucassolutions.schoolbus.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.dao.SchoolDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.facade.StudentFacade;
import br.com.lucassolutions.schoolbus.model.Period;
import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.util.DateHelper;

@Controller
@RequestMapping("/controller/user")
public class StudentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
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
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public String saveStudent(ModelMap model, @RequestParam("name") String name, @RequestParam("responsibleName") String responsibleName, @RequestParam("telephone") String telephone,
			@RequestParam("period") String period, @RequestParam("paymentValue") Double paymentValue, @RequestParam("school") Long school,
			@RequestParam("paymentDate") @DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate paymentDate) {
		LOGGER.info("Saving student with name: " + name + ", telephone: " + telephone + " and responsible name: " + responsibleName + "and date payment: "+ paymentDate);
		
		School school2 = schoolDao.findById(school);
		
		Student student = new Student();
		
		student.setName(name);
		student.setTelephone(telephone);
		student.setResponsibleName(responsibleName);
		student.setPeriod(period);
		student.setValuePayment(paymentValue);
		student.setSchool(school2);
		student.setPaymentDate(paymentDate);
		studentDao.save(student);
		
		return registerView(model);
	}
	
}