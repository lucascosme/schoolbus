package br.com.lucassolutions.schoolbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.SchoolDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.model.Student;

@Service
public class StudentService {
	
	@Autowired SchoolDao schoolDao;
	@Autowired StudentDao studentDao;

	public List<School> getSchools() {
		List<School> schools = schoolDao.findAll();
		return schools;
	}

	public List<Student> searchStudentName(String name) {
		List<Student> students = studentDao.findByNameWithLike(name);
		return students;
	}
}