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

	public void saveStudent(String name, String homePhone, String responsibleName, String celPhone,
			String messagePhone, String address, String neighborhood, String complement, String period,
			Double paymentValue, Long schoolId, LocalDate paymentDate) {
		
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
		student.setHomePhone(homePhone);
		student.setCelPhone(celPhone);
		student.setMessagePhone(messagePhone);
		student.setAddress(address);
		student.setNeighborhood(neighborhood);
		student.setComplement(complement);
		student.setResponsibleName(responsibleName);
		student.setPeriod(period);
		student.setValuePayment(paymentValue);
		student.setSchool(school);
		student.setPaymentDate(paymentDate);
		student.setStatus(StudentStatus.ACTIVE);
		student.setPayment(payments);

		studentDao.save(student);
		paymentDao.save(payment);
		
	}

	public List<Student> getStudents() {
		return studentDao.findByStatus(StudentStatus.ACTIVE);
	}

	public List<Student> searchStudent(String name) {
		return studentDao.findByNameAndStatusWithLike(name, StudentStatus.ACTIVE);
	}

	public void disableStudent(Long studentId) {
		studentDao.updateStatus(studentId, StudentStatus.DISABLE);
	}
}