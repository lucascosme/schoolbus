package br.com.lucassolutions.schoolbus.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Expense;
import br.com.lucassolutions.schoolbus.model.ExpenseStatus;

@Repository
public class ExpenseDao extends HibernateGenericDao<Expense> {

	public ExpenseDao() {
		super(Expense.class);
	}
	
	public Collection<Expense> findByDate(LocalDate initialDate, LocalDate endDate, ExpenseStatus... expensesStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
				Restrictions.in("status", expensesStatus),
				Restrictions.between("dateExpense", initialDate, endDate)
			)
		);
		return findByCriterionAndOrderByAsc(criterions, "dateExpense");
	}
}
