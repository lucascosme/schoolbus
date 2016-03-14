package br.com.lucassolutions.schoolbus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.Student;

@Repository
public class StudentDao extends HibernateGenericDao<Student>{

	private static final String WHATEVER = "%";

	public StudentDao(){
		super(Student.class);
	}
	
	public List<Student> findByNameWithLike(String name, PaymentStatus... paymentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
			Restrictions.ilike("name", name + WHATEVER)));
		return findByCriterion(criterions);
	}
}