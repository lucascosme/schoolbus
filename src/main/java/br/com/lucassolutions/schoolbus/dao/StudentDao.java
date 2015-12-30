package br.com.lucassolutions.schoolbus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Student;

@Repository
public class StudentDao extends HibernateGenericDao<Student>{

	private static final String WHATEVER = "%";

	public StudentDao(){
		super(Student.class);
	}
	
	public List<Student> findByName(String name) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(Restrictions.ilike("name", name + WHATEVER));
		return findByCriterion(criterions);
	}
}
