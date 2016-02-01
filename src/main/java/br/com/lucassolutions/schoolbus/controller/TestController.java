package br.com.lucassolutions.schoolbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.model.Student;

@Controller
@RequestMapping("/controller/user")
public class TestController {
	
	@Autowired private StudentDao studentDao;
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	@RequestMapping(value="/teststudent", method=RequestMethod.POST)
	public void tests() {
		List<Student> students = studentDao.findByNameWithLike("Ju");
		for (Student student : students) {
			System.out.println(student.getName());
			System.out.println(student.getPeriod());
		}
	}
}
