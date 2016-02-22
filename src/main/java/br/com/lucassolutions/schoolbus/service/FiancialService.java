package br.com.lucassolutions.schoolbus.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.ExpenseDao;
import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.model.Expense;
import br.com.lucassolutions.schoolbus.model.ExpenseStatus;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.Student;

@Service
public class FiancialService {

	@Autowired private StudentDao studentDao;
	@Autowired private PaymentDao paymentDao;
	@Autowired private ExpenseDao expenseDao;
	
	public List<Student> searchStudentName(String name) {
		List<Student> listStudent = studentDao.findByNameWithLike(name);
		return listStudent;
	}

	public Payment getPaymentByStudentId(Long studentId) {
		Payment payment = paymentDao.findById(studentId);
		return payment;
	}

	public Collection<Payment> getPaymentsByRangeDate(LocalDate startDate,LocalDate endDate) {
		Collection<Payment> payments = paymentDao.findByDate(startDate,endDate,PaymentStatus.FINALIZED);
		return payments;
	}

	public Collection<Expense> getExpensesByRangeDate(LocalDate startDate, LocalDate endDate) {
		Collection<Expense> expenses = expenseDao.findByDate(startDate, endDate, ExpenseStatus.OPENED,ExpenseStatus.PAID_OUT);
		return expenses;
	}
}