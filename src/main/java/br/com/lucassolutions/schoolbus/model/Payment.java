package br.com.lucassolutions.schoolbus.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.lucassolutions.schoolbus.model.converter.LocalDatePersistenceConverter;

@Entity
@Table(name="payments")
public class Payment extends DomainModel{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Student student;
	
	@Column
	private double value;
	
	@Column
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate expirationDate;
	
	@Enumerated(value=EnumType.STRING)
	private PaymentStatus status;
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public PaymentStatus getStatus() {
		return status;
	}
	
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
}