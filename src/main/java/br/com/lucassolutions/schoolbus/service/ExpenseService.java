package br.com.lucassolutions.schoolbus.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.ExpenseDao;
import br.com.lucassolutions.schoolbus.model.Expense;
import br.com.lucassolutions.schoolbus.model.ExpenseStatus;

@Service
public class ExpenseService {

	@Autowired ExpenseDao expenseDao;
	
	public void saveExpense(String expenseName, double value, LocalDate dateExpense) {
		Expense expense = new Expense();
		expense.setExpense(expenseName);
		expense.setValue(value);
		expense.setDateExpense(dateExpense);
		expense.setStatus(ExpenseStatus.PAID_OUT);
		
		expenseDao.save(expense);
	}
}
