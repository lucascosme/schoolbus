package br.com.lucassolutions.schoolbus.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.service.StudentService;

@Component
public class StudentFacade {

	@Autowired StudentService studentService;
	
	public List<School> getSchools() {
		List<School> schools = studentService.getSchools();
		return schools;
	}

	public List<Student> searchStudentName(String name) {
		return studentService.searchStudentName(name);
	}

}
