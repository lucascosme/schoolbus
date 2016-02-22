package br.com.lucassolutions.schoolbus.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.lucassolutions.schoolbus.model.converter.LocalDatePersistenceConverter;

@Entity
@Table(name="expenses")
public class Expense extends DomainModel {

	private static final long serialVersionUID = 1L;
	
	@Column
	private String expense;
	
	@Column
	private Double value;
	
	@Column
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate dateExpense;
	
	@Enumerated(value = EnumType.STRING)
	private ExpenseStatus status;

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public LocalDate getDateExpense() {
		return dateExpense;
	}

	public void setDateExpense(LocalDate dateExpense) {
		this.dateExpense = dateExpense;
	}

	public ExpenseStatus getStatus() {
		return status;
	}

	public void setStatus(ExpenseStatus status) {
		this.status = status;
	}
}