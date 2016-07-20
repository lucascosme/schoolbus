package br.com.lucassolutions.schoolbus.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.dao.ResponsibleDao;
import br.com.lucassolutions.schoolbus.dao.SchoolDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.Responsible;
import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.model.StudentStatus;

@Service
public class StudentService {
	
	@Autowired SchoolDao schoolDao;
	@Autowired StudentDao studentDao;
	@Autowired PaymentDao paymentDao;
	@Autowired ResponsibleDao responsibleDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	private static final int RECORDEPERPAGE = 3;

	public List<School> getSchools() {
		List<School> schools = schoolDao.findAll();
		return schools;
	}

	public void saveStudent(String name, String period,
			Double paymentValue, Long schoolId, LocalDate paymentDate, Long responsibleId) {
		
		Responsible responsible = responsibleDao.findById(responsibleId);
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
		student.setResponsible(responsible);
		student.setPeriod(period);
		student.setValuePayment(paymentValue);
		student.setSchool(school);
		student.setPaymentDate(paymentDate);
		student.setStatus(StudentStatus.ACTIVE);
		student.setPayment(payments);

		studentDao.save(student);
		paymentDao.save(payment);
		
	}

	public List<Student> getStudents(int page) {
		List<Student> allStudentsWithPagination = studentDao.getAllStudentsWithPagination(page, RECORDEPERPAGE);
		LOGGER.info("QUANTIDADES DE ALUNOS ENCONTRADOS: "+allStudentsWithPagination.size());
		for (Student student : allStudentsWithPagination) {
					LOGGER.info("ALUNO: " + student.getName());
		}
		return allStudentsWithPagination;
	}
	
	public int numberOfPages(){
		double studentsActive = (double)studentDao.countStudentByStudent(StudentStatus.ACTIVE);
		LOGGER.info("ESTUDANTES ATIVOS ENCONTRADOS: "+ studentsActive);
		double division = studentsActive/RECORDEPERPAGE;
		return (int)Math.ceil(division);
	}

	public List<Student> searchStudent(String name) {
		return studentDao.findByNameAndStatusWithLike(name, StudentStatus.ACTIVE);
	}

	public void disableStudent(Long studentId) {
		studentDao.updateStatus(studentId, StudentStatus.DISABLE);
	}

	public Responsible getResponsible(Long responsibleId) {
		return responsibleDao.findById(responsibleId);
	}
}