package br.com.lucassolutions.schoolbus.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.facade.ExpenseFacade;
import br.com.lucassolutions.schoolbus.util.DateHelper;

@Controller
@RequestMapping("/controller/user")
public class ExpenseController {

	@Autowired ExpenseFacade expenseFacade;
	
	@RequestMapping("/saveExpenseView")
	public String saveExpenseView(){
		return "registerExpense";
	}
	
	@RequestMapping("/saveExpense")
		public String saveExpense(ModelMap model,@RequestParam("expenseName")String expenseName,
				@RequestParam("value")double value,
				@RequestParam("dateExpense")@DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate dateExpense){
		expenseFacade.saveExpense(expenseName,value,dateExpense);
		return saveExpenseView();
	}
}
