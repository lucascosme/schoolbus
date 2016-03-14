package br.com.lucassolutions.schoolbus.controller;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.facade.FiancialFacade;
import br.com.lucassolutions.schoolbus.model.Expense;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.service.FiancialService;
import br.com.lucassolutions.schoolbus.util.DateHelper;

@Controller
@RequestMapping("/controller/user")
public class FinancialController {
	
	@Autowired private FiancialFacade fiancialFacade;
	@Autowired private PaymentDao paymentDao;
	@Autowired private FiancialService fiancialService;
	@Autowired private StudentDao studentDao;
	@Autowired private DateHelper dateHelper;
	
	@RequestMapping("/showPaymentView")
	public String showPaymentView(ModelMap model){
		return "showPayment";
	}
	
	@RequestMapping(value="/searchStudent", method=RequestMethod.POST)
	public String searchStudent(ModelMap model,@RequestParam("name") String name){
		Collection<Payment> listPayments = fiancialFacade.searchStudentName(name);
		model.addAttribute("listPayments", listPayments);
		return showPaymentView(model);
	}
	
	@RequestMapping("/newPaymentView")
	public String newPaymentView(ModelMap model,@RequestParam("studentId")Long studentId){
		Payment payment = fiancialFacade.getPaymentByStudentId(studentId);
		model.addAttribute("payment", payment);
		return "newPayment";
	}
	
	@RequestMapping("/saveNewPayment")
	public String saveNewPayment(ModelMap model,@RequestParam("paymentId")Long paymentId){
		
		Payment payment = paymentDao.findById(paymentId);
		LocalDate expirationDate = payment.getExpirationDate();
		LocalDate newExpirationDate = dateHelper.addOneMonth(expirationDate);
		
		payment.setExpirationDate(newExpirationDate);
		payment.setLastPayment(LocalDate.now());
		payment.setStatus(PaymentStatus.OPENED);
		payment.setValue(payment.getValue());
		
		paymentDao.save(payment);
		
		paymentDao.updateStatus(paymentId, PaymentStatus.FINALIZED);
		
		
		
		return newPaymentView(model, 1L);
	}
	
	@RequestMapping("/balanceView")
	public String balanceView(ModelMap model){
		return "balance";
	}
	
	@RequestMapping("/balanceCalc")
	public String balanceCalc(ModelMap model,
			@RequestParam("startDate")@DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate startDate,
			@RequestParam("endDate")@DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate endDate){
		Collection<Payment> payments = fiancialFacade.getPaymentsByRangeDate(startDate,endDate);
		Collection<Expense> expenses = fiancialFacade.getExpensesByRangeDate(startDate,endDate);
		double paymentSum = fiancialService.paymentSum(payments);
		double expenseSum = fiancialService.expenseSum(expenses);
		double receivingLiquid = fiancialService.receivingLiquid(paymentSum, expenseSum);
		
		model.addAttribute("payments", payments);
		model.addAttribute("expenses", expenses);
		model.addAttribute("paymentSum", paymentSum);
		model.addAttribute("expenseSum", expenseSum);
		model.addAttribute("paymentSize", payments.size());
		model.addAttribute("expenseSize", expenses.size());
		model.addAttribute("receivingLiquid", receivingLiquid);
		return balanceView(model);
	}
}
