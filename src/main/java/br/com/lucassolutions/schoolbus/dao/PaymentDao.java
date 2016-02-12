package br.com.lucassolutions.schoolbus.dao;

import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Payment;

@Repository
public class PaymentDao extends HibernateGenericDao<Payment>{
	
	public PaymentDao() {
		super(Payment.class);
	}
}