package br.com.lucassolutions.schoolbus.facade;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.service.ExpenseService;

@Component
public class ExpenseFacade {

	@Autowired ExpenseService expenseService;
	
	public void saveExpense(String expenseName, double value, LocalDate dateExpense) {
		expenseService.saveExpense(expenseName,value,dateExpense);
	}

}
