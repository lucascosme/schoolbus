package br.com.lucassolutions.schoolbus.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.service.FiancialService;

@Component
public class FiancialFacade {

	@Autowired private FiancialService fiancialService;
	
	public List<Student> searchStudentName(String name) {
		return fiancialService.searchStudentName(name);
	}

	public Payment getPayment(Long studentId) {
		return fiancialService.getPayment(studentId);
	}

}
