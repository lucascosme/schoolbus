package br.com.lucassolutions.schoolbus.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.PaymentStatus;
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
	
	public void updatePaymentDate(Long studentId, LocalDate paymentDate){
		Student student = findById(studentId);
		student.setPaymentDate(paymentDate);
		update(student);
	}
	
	public Collection<Student> findByStatusAndStudentNameAndStatusPayment(String name, PaymentStatus... paymentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(Restrictions.and(
				Restrictions.eq("status", StudentStatus.ACTIVE),
				Restrictions.ilike("name", name, MatchMode.START)
				));
		
		Criterion criterionJoin = Restrictions.eq("payment.status", PaymentStatus.OPENED);
		
		String joinTable = "payment";
		
		String propertyNameToOrderBy = "name";
		return findByCriterionWithJoinAndOrderByDesc(criterions, criterionJoin , joinTable, propertyNameToOrderBy);
	}
	
	public List<Student> getAllStudentsWithPagination(int page, int recordePerPage) {

		 String hql = "from Student where status = 'ACTIVE'";
		 Query query = currentSession().createQuery(hql);
		             query.setFirstResult(recordePerPage * ( (page-1)+1));
		             query.setMaxResults(recordePerPage);
		             @SuppressWarnings("unchecked")
		             List<Student> list = query.list();
		            
		             return list;
		 }
	
	public int countStudentByStudent(StudentStatus studentStatus){
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
				Restrictions.eq("status", studentStatus)
		);
		return countByCriterion(criterions);
	}
	
}