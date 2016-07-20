package br.com.lucassolutions.schoolbus.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lucassolutions.schoolbus.controller.bean.StudentBean;
import br.com.lucassolutions.schoolbus.controller.bean.StudentPaginator;
import br.com.lucassolutions.schoolbus.facade.StudentFacade;
import br.com.lucassolutions.schoolbus.model.Message;
import br.com.lucassolutions.schoolbus.model.MessageKey;
import br.com.lucassolutions.schoolbus.model.Period;
import br.com.lucassolutions.schoolbus.model.Responsible;
import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.model.StudentStatus;
import br.com.lucassolutions.schoolbus.util.DateHelper;

@Controller
@RequestMapping("/controller/user")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	private static final String REGISTER_STUDENT_VIEW = "registerStudent";

	private static final int ZERO = 0;

	@Autowired
	private StudentFacade studentfacade;
	
	@RequestMapping("/screenStudent")
	public String screenStudent(ModelMap model) {
		return "screenStudent";
	}

	@RequestMapping("/registerStudentView")
	public String registerView(ModelMap model,@RequestParam("responsibleId")Long responsibleId) {
		List<School> schools = studentfacade.getSchools();
		Responsible responsible = studentfacade.getResponsible(responsibleId);
		model.addAttribute("listSchool", schools);
		model.addAttribute("periods", Period.values());
		model.addAttribute("responsible", responsible);
		return REGISTER_STUDENT_VIEW;
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(ModelMap model, @RequestParam("name") String name, @RequestParam("period") String period,
			@RequestParam("paymentValue") Double paymentValue, @RequestParam("school") Long schoolId,
			@RequestParam("responsible")Long responsibleId, @RequestParam("paymentDate") 
			@DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate paymentDate) {
		try {
			LOGGER.info("Saving student with name: " + name + "and date payment: " + paymentDate);
			studentfacade.saveStudent(name, period, paymentValue, schoolId, paymentDate,responsibleId);
			model.addAttribute(MessageKey.SUCESS.getKey(), Message.SAVE_SUCSESSFUL.getKey());
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SAVE_ERROR.getKey());
		}
		return screenStudent(model);
	}

	@RequestMapping(value = "/demandStudent", method = RequestMethod.POST)
	public String searchStudent(ModelMap model, @RequestParam(value = "name", required = true) String name) {
		try {
			if (name.isEmpty()) {
				model.addAttribute(MessageKey.ERROR.getKey(), Message.NAME_IS_EMPTY.getKey());
			} else {
				List<Student> listStudents = studentfacade.searchStudent(name);
				model.addAttribute("listStudents", listStudents);
				model.addAttribute("listSizeSearch", listStudents.size());
				if (listStudents.size() == 0) {
					model.addAttribute(MessageKey.WARNING.getKey(), Message.NOT_FOUND_STUDENT.getKey());
				}
			}
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_ERROR.getKey());
			LOGGER.info("ERRO AO BUSCAR ALUNO, EXCEPTION: " + e);
		}
		return screenStudent(model);
	}

	@RequestMapping("/demandStudentAll")
	public String demandStudentAll(ModelMap model) {
		try {
			int page = ZERO;
			List<Student> students = studentfacade.getStudents(page);
			int numberOfPages = studentfacade.numberOfPages();
			
			model.addAttribute("students", students);
			model.addAttribute("listSize", students.size());
			model.addAttribute("page", ZERO);
			model.addAttribute("numberOfPages", numberOfPages);
			if (students.size() == 0){
				model.addAttribute(MessageKey.WARNING.getKey(), Message.DONT_HAVE_DATA.getKey());
			}
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_ERROR.getKey());
			LOGGER.info("ERRO AO LISTAR ESTUDANTES: "+e);
		}
		return screenStudent(model);
	}
	@RequestMapping(value = "/nextPage",
			method = RequestMethod.GET, 
			produces = "application/json")
	public @ResponseBody StudentPaginator nextPage(@RequestParam("currentPage") int currentPage){
		/*try {*/
			int page = currentPage + 1;
			Collection<Student> students = studentfacade.getStudents(page);
			int numberOfPages = studentfacade.numberOfPages();
			
			Collection<StudentBean> studentBeans = new ArrayList<>();
			for (Student student : students) {
				Long id = student.getId();
				String name = student.getName();
				StudentStatus status = student.getStatus();
				
				StudentBean studentBean = new StudentBean();
				studentBean.setId(id);
				studentBean.setName(name);
				studentBean.setStatus(status.name());
				studentBeans.add(studentBean);
			}
			
			StudentPaginator paginator = new StudentPaginator();
			paginator.setStudentBeans(studentBeans);
			paginator.setListSize(students.size());
			paginator.setPage(page);
			paginator.setNumberOfPages(numberOfPages);
			
			return paginator;
		/*} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_ERROR.getKey());
		}
		return screenStudent(model);*/
	}
	
	@RequestMapping("/previousPage")
	public String previousPage(ModelMap model, @RequestParam("actualPage")int actualPage){
		try {
			int page = actualPage - 1;
			List<Student> students = studentfacade.getStudents(page);
			int numberOfPages = studentfacade.numberOfPages();
			
			model.addAttribute("students", students);
			model.addAttribute("listSize", students.size());
			model.addAttribute("page", page);
			model.addAttribute("numberOfPages", numberOfPages);
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.SEARCH_ERROR.getKey());
		}
		return screenStudent(model);
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent(ModelMap model, @RequestParam("studentId") Long studentId) {
		try {
			studentfacade.disableStudent(studentId);
			model.addAttribute(MessageKey.SUCESS.getKey(), Message.DELETE_ERROR.getKey());
		} catch (Exception e) {
			model.addAttribute(MessageKey.ERROR.getKey(), Message.DELETE_SUCCESSFUL.getKey());
			LOGGER.info("ERRO AO DELETAR ALUNO, EXCEPTION: " + e);
		}
		return screenStudent(model);
	}
}