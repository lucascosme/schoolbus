package br.com.lucassolutions.schoolbus.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Column
	private String responsibleName;
	
	@Column
	private String homePhone;
	
	@Column
	private String celPhone;
	
	@Column
	private String messagePhone;
	
	@Column
	private String address;
	
	@Column
	private String neighborhood;
	
	@Column
	private String complement;

	@ManyToOne
	private School school;
	
	@Column
	private String period;
	
	@Column
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate paymentDate;
	
	@OneToMany(mappedBy="student", targetEntity = Payment.class)
	private List<Payment> payment;
	
	@Column
	private double valuePayment;
	
	@Enumerated(value = EnumType.STRING)
	private StudentStatus status;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getComplement() {
		return complement;
	}
	
	public void setComplement(String complement) {
		this.complement = complement;
	}

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
	
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCelPhone() {
		return celPhone;
	}

	public void setCelPhone(String celPhone) {
		this.celPhone = celPhone;
	}

	public String getMessagePhone() {
		return messagePhone;
	}
	
	public void setMessagePhone(String messagePhone) {
		this.messagePhone = messagePhone;
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

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
}
