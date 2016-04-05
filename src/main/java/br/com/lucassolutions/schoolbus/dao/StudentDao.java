package br.com.lucassolutions.schoolbus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.model.StudentStatus;

@Repository
public class StudentDao extends HibernateGenericDao<Student>{

	private static final String WHATEVER = "%";

	public StudentDao(){
		super(Student.class);
	}
	
	public List<Student> findByNameAndStatusWithLike(String name,StudentStatus...studentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
			Restrictions.ilike("name", name + WHATEVER),
			Restrictions.in("status", studentStatus)));
		return findByCriterion(criterions);
	}
	
	public List<Student> findByStatus(StudentStatus...studentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
			Restrictions.in("status", studentStatus)));
		return findByCriterion(criterions);
	}
	
	public void updateStatus(Long studentId,StudentStatus studentStatus) {
		Student student = findById(studentId);
		student.setStatus(studentStatus);
		update(student);
	}
	
}