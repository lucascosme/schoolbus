package br.com.lucassolutions.schoolbus.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.lucassolutions.schoolbus.model.converter.LocalDatePersistenceConverter;

@Entity
@Table(name="students")
public class Student extends DomainModel {

	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@ManyToOne
	private School school;
	
	@Column
	private String period;
	
	@Column
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate paymentDate;
	
	@OneToMany(mappedBy="student", targetEntity = Payment.class)
	private List<Payment> payment;
	
	@ManyToOne
	@JoinColumn(name="responsible_id")
	private Responsible responsible;
	
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

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public Responsible getResponsible() {
		return responsible;
	}

	public void setResponsible(Responsible responsible) {
		this.responsible = responsible;
	}

	public double getValuePayment() {
		return valuePayment;
	}

	public void setValuePayment(double valuePayment) {
		this.valuePayment = valuePayment;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}
}