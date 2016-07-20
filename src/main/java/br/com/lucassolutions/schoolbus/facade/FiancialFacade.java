package br.com.lucassolutions.schoolbus.facade;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.Expense;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.service.FiancialService;

@Component
public class FiancialFacade {

	@Autowired private FiancialService fiancialService;
	
	public Collection<Student> searchStudentName(String name) {
		return fiancialService.searchStudentName(name);
	}

	public Collection<Payment> getPaymentByStudentId(Long studentId) {
		return fiancialService.getPaymentByStudentId(studentId);
	}

	public Collection<Payment> getPaymentsByRangeDate(LocalDate startDate, LocalDate endDate) {
		return fiancialService.getPaymentsByRangeDate(startDate,endDate);
	}

	public Collection<Expense> getExpensesByRangeDate(LocalDate startDate, LocalDate endDate) {
		return fiancialService.getExpensesByRangeDate(startDate,endDate);
	}

	public Long updatePayment(Long paymentId) {
		return fiancialService.updatePayment(paymentId);
	}
}