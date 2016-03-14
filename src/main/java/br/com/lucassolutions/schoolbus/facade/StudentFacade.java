package br.com.lucassolutions.schoolbus.facade;

import java.time.LocalDate;
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

	public void saveStudent(String name, String telephone, String responsibleName, String period, Double paymentValue,
			Long schoolId, LocalDate paymentDate) {
		studentService.saveStudent(name,telephone,responsibleName,period,paymentValue,schoolId,paymentDate);
	}

}
