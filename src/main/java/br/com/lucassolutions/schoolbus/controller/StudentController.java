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

import br.com.lucassolutions.schoolbus.facade.StudentFacade;
import br.com.lucassolutions.schoolbus.model.Message;
import br.com.lucassolutions.schoolbus.model.MessageKey;
import br.com.lucassolutions.schoolbus.model.Period;
import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.util.DateHelper;

@Controller
@RequestMapping("/controller/user")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	private static final String REGISTER_STUDENT_VIEW = "registerStudent";

	@Autowired
	private StudentFacade studentfacade;

	@RequestMapping("/screenStudent")
	public String screenStudent(ModelMap model) {
		return "screenStudent";
	}

	@RequestMapping("/registerStudentView")
	public String registerView(ModelMap model) {
		List<School> schools = studentfacade.getSchools();
		model.addAttribute("listSchool", schools);
		model.addAttribute("periods", Period.values());
		return REGISTER_STUDENT_VIEW;
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(ModelMap model, @RequestParam("name") String name,
			@RequestParam("responsibleName") String responsibleName, @RequestParam("homePhone") String homePhone,
			@RequestParam("celPhone") String celPhone, @RequestParam("messagePhone") String messagePhone,
			@RequestParam("address") String address, @RequestParam("neighborhood") String neighborhood,
			@RequestParam("complement") String complement, @RequestParam("period") String period,
			@RequestParam("paymentValue") Double paymentValue, @RequestParam("school") Long schoolId,
			@RequestParam("paymentDate") @DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate paymentDate) {
		try {
			LOGGER.info("Saving student with name: " + name + ", telephone: " + homePhone + " and responsible name: "
					+ responsibleName + "and date payment: " + paymentDate);
			studentfacade.saveStudent(name, homePhone, responsibleName, celPhone, messagePhone, address, neighborhood,
					complement, period, paymentValue, schoolId, paymentDate);
			model.addAttribute(MessageKey.SUCESS.getKey(), Message.SAVE_STUDENT_SUCSESSFUL.getKey());
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SAVE_STUDENT_ERROR.getKey());
		}
		return screenStudent(model);
	}

	@RequestMapping(value = "/demandStudent", method = RequestMethod.POST)
	public String searchStudent(ModelMap model, @RequestParam(value = "name", required = true) String name) {
		try {
			if (name.isEmpty()) {
				model.addAttribute(MessageKey.ERROR.getKey(), Message.NAME_STUDENT_IS_EMPTY.getKey());
			} else {
				List<Student> listStudents = studentfacade.searchStudent(name);
				model.addAttribute("listStudents", listStudents);
				model.addAttribute("listSizeSearch", listStudents.size());
				if (listStudents.size() == 0) {
					model.addAttribute(MessageKey.WARNING.getKey(), Message.NOT_FOUND_STUDENT.getKey());
				}
			}
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_STUDENT_ERROR.getKey());
			LOGGER.info("ERRO AO BUSCAR ALUNO, EXCEPTION: " + e);
		}
		return screenStudent(model);
	}

	@RequestMapping("/demandStudentAll")
	public String demandStudentAll(ModelMap model) {
		try {
			List<Student> students = studentfacade.getStudents();
			model.addAttribute("students", students);
			model.addAttribute("listSize", students.size());
			if (students.size() == 0){
				model.addAttribute(MessageKey.WARNING.getKey(), Message.DONT_HAVE_STUDENT.getKey());
			}
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_STUDENT_ERROR.getKey());
			LOGGER.info("ERRO AO LISTAR ESTUDANTES: "+e);
		}
		return screenStudent(model);
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent(ModelMap model, @RequestParam("studentId") Long studentId) {
		try {
			studentfacade.disableStudent(studentId);
			model.addAttribute(MessageKey.SUCESS.getKey(), Message.DELETE_STUDENT_SUCCESSFUL.getKey());
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.DELETE_STUDENT_ERROR.getKey());
			LOGGER.info("ERRO AO DELETAR ALUNO, EXCEPTION: " + e);
		}
		return screenStudent(model);
	}
}