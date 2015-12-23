package br.com.lucassolutions.schoolbus.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Payment extends DomainModel{

	private static final long serialVersionUID = 1L;
	
	@Column
	@ManyToOne(fetch=FetchType.EAGER)
	private Student student;
	@Column
	private double value;
	@Column
	private LocalDate expirationDate;
	@Column
	private PaymentStatus status;
}
