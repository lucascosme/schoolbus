package br.com.lucassolutions.schoolbus.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.dao.SchoolDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.model.StudentStatus;

@Service
public class StudentService {
	
	@Autowired SchoolDao schoolDao;
	@Autowired StudentDao studentDao;
	@Autowired PaymentDao paymentDao;

	public List<School> getSchools() {
		List<School> schools = schoolDao.findAll();
		return schools;
	}

	public List<Student> searchStudentName(String name) {
		List<Student> students = studentDao.findByNameWithLike(name);
		return students;
	}

	public void saveStudent(String name, String telephone, String responsibleName, String period, Double paymentValue,
			Long schoolId, LocalDate paymentDate) {
		
		School school = schoolDao.findById(schoolId);
		
		Student student = new Student();
		Payment payment = new Payment();
		List<Payment> payments = new ArrayList<>();
		payment.setExpirationDate(paymentDate);
		payment.setValue(paymentValue);
		payment.setLastPayment(LocalDate.now());
		payment.setStatus(PaymentStatus.OPENED);
		payment.setStudent(student);
		
		student.setName(name);
		student.setTelephone(telephone);
		student.setResponsibleName(responsibleName);
		student.setPeriod(period);
		student.setValuePayment(paymentValue);
		student.setSchool(school);
		student.setPaymentDate(paymentDate);
		student.setStatus(StudentStatus.ACTIVE);
		student.setPayment(payments);

		paymentDao.save(payment);
		studentDao.save(student);
		
	}
}