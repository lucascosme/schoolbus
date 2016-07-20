package br.com.lucassolutions.schoolbus.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="responsibles")
public class Responsible extends DomainModel{

	private static final long serialVersionUID = 1L;

	@Column
	private String name;
	
	@Column(unique = true)
	private String documentNumber;
	
	@OneToMany(mappedBy="responsible", targetEntity = Student.class)
	private List<Student> student;
	
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
	
	@Enumerated(value = EnumType.STRING)
	private ResponsibleStatus status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
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

	public ResponsibleStatus getStatus() {
		return status;
	}

	public void setStatus(ResponsibleStatus status) {
		this.status = status;
	}
}
