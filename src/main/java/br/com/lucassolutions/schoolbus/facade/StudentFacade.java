package br.com.lucassolutions.schoolbus.facade;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.Responsible;
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

	public List<Student> searchStudent(String name) {
		return studentService.searchStudent(name);
	}
	
	public void saveStudent(String name, String period,
			Double paymentValue, Long schoolId, LocalDate paymentDate,Long responsibleId) {
		studentService.saveStudent(name,period,paymentValue,schoolId,paymentDate,responsibleId);
	}

	public List<Student> getStudents(int page) {
		return studentService.getStudents(page);
		
	}

	public void disableStudent(Long studentId) {
		studentService.disableStudent(studentId);
	}

	public Responsible getResponsible(Long responsibleId) {
		return studentService.getResponsible(responsibleId);
	}
	
	public int numberOfPages(){
		return studentService.numberOfPages();
	}
}
