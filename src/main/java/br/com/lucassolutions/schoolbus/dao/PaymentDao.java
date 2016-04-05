package br.com.lucassolutions.schoolbus.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.Student;

@Repository
public class PaymentDao extends HibernateGenericDao<Payment>{
	
	public PaymentDao() {
		super(Payment.class);
	}
	
	public Collection<Payment> findByDate(LocalDate initialDate, LocalDate endDate, PaymentStatus... paymentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
				Restrictions.in("status", paymentStatus),
				Restrictions.between("expirationDate", initialDate, endDate)
			)
		);
		return findByCriterionAndOrderByAsc(criterions, "expirationDate");
	}
	
	public void updateStatus(Long paymentId,PaymentStatus paymentStatus) {
		Payment payment = findById(paymentId);
		payment.setStatus(paymentStatus);
		update(payment);
	}
	
	public Collection<Payment> findByStatus(List<Student> studentsid, PaymentStatus... paymentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
				Restrictions.in("status", paymentStatus),
				Restrictions.in("student_id", studentsid.toArray())
			)
		);
		return findByCriterion(criterions);
	}
}