package br.com.lucassolutions.schoolbus.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import br.com.lucassolutions.schoolbus.model.converter.LocalDatePersistenceConverter;

@Entity
public class Student extends DomainModel {

	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@Column
	private String responsibleName;
	
	@Column
	private String telephone;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private School school;
	
	@Column
	private String period;
	
	@Column
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate paymentDate;
	
	@Column
	private double valuePayment;
	
	@Enumerated(value = EnumType.STRING)
	private StudentStatus status;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getResponsibleName() {
		return responsibleName;
	}
	
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public School getSchool() {
		return school;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public double getValuePayment() {
		return valuePayment;
	}
	
	public void setValuePayment(double value) {
		this.valuePayment = value;
	}
	
	public StudentStatus getStatus() {
		return status;
	}
	
	public void setStatus(StudentStatus status) {
		this.status = status;
	}
}
