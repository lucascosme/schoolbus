package br.com.lucassolutions.schoolbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.Student;

@Service
public class FiancialService {

	@Autowired private StudentDao studentDao;
	@Autowired private PaymentDao paymentDao;
	
	public List<Student> searchStudentName(String name) {
		List<Student> listStudent = studentDao.findByNameWithLike(name);
		return listStudent;
	}

	public Payment getPayment(Long studentId) {
		Payment payment = paymentDao.findById(studentId);
		return payment;
	}
}