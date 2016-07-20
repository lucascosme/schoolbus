package br.com.lucassolutions.schoolbus.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.StudentStatus;

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
	
	public void updateStatusAndLastPayment(Long paymentId,PaymentStatus paymentStatus, LocalDate lastPayment) {
		Payment payment = findById(paymentId);
		payment.setStatus(paymentStatus);
		payment.setLastPayment(lastPayment);
		update(payment);
	}
	
	public Collection<Payment> findByStatusAndStudentId(Long studentId, PaymentStatus... paymentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
				Restrictions.and(
						Restrictions.eq("student.id", studentId),
						Restrictions.in("status", paymentStatus)
						));
		return findByCriterion(criterions);
	}
	
	public Collection<Payment> findByStatusAndActiveStudentName(String name, PaymentStatus... paymentStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(Restrictions.in("status", paymentStatus));
		
		Criterion criterionJoin = Restrictions.and(
				Restrictions.eq("student.status", StudentStatus.ACTIVE), 
				Restrictions.ilike("student.name", name, MatchMode.START)
				);
		String joinTable = "student";
		
		String propertyNameToOrderBy = "student.name";
		return findByCriterionWithJoinAndOrderByDesc(criterions, criterionJoin , joinTable, propertyNameToOrderBy );
	}
}