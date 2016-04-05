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

	public List<Student> searchStudent(String name) {
		return studentService.searchStudent(name);
	}
	
	public void saveStudent(String name, String homePhone, String responsibleName, String celPhone,
			String messagePhone, String address, String neighborhood, String complement, String period,
			Double paymentValue, Long schoolId, LocalDate paymentDate) {
		studentService.saveStudent(name,homePhone,responsibleName,celPhone,messagePhone,address,neighborhood,
				complement,period,paymentValue,schoolId,paymentDate);
	}

	public List<Student> getStudents() {
		return studentService.getStudents();
		
	}

	public void disableStudent(Long studentId) {
		studentService.disableStudent(studentId);
	}
}
