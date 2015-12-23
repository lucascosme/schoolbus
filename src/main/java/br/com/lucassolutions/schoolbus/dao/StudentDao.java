package br.com.lucassolutions.schoolbus.dao;

import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Student;

@Repository
public class StudentDao extends HibernateGenericDao<Student>{

	public StudentDao(){
		super(Student.class);
	}
}
