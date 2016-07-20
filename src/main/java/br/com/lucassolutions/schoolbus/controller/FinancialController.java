package br.com.lucassolutions.schoolbus.controller;

import java.time.LocalDate;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.facade.FiancialFacade;
import br.com.lucassolutions.schoolbus.model.Expense;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.service.FiancialService;
import br.com.lucassolutions.schoolbus.util.DateHelper;

@Controller
@RequestMapping("/controller/user")
public class FinancialController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FinancialController.class);

	
	@Autowired private FiancialFacade fiancialFacade;
	@Autowired private PaymentDao paymentDao;
	@Autowired private FiancialService fiancialService;
	@Autowired private DateHelper dateHelper;
	
	@RequestMapping("/showPaymentView")
	public String showPaymentView(ModelMap model){
		return "showPayment";
	}
	
	@RequestMapping("/searchStudent")
	public String searchStudent(ModelMap model,@RequestParam("name") String name){
		LOGGER.info("BUSCANDO PAGAMENTO");
		Collection<Student> listStudents = fiancialFacade.searchStudentName(name);
		model.addAttribute("listStudents", listStudents);
		model.addAttribute("listStudentsSize", listStudents.size());
		LOGGER.info("QUANTIDADE DE PAGAMENTOS ENCONTRADOS: " + listStudents.size());
		return showPaymentView(model);
	}
	
	@RequestMapping("/newPaymentView")
	public String newPaymentView(ModelMap model,@RequestParam("studentId")Long studentId){
		Collection<Payment> listPayment = fiancialFacade.getPaymentByStudentId(studentId);
		model.addAttribute("listPayment", listPayment);
		model.addAttribute("listPaymentsSize", listPayment.size());
		LOGGER.info("QUANTIDADE DE PAGAMENTOS EM ABERTO :"+listPayment.size());
		return "newPayment";
	}
	
	@RequestMapping("/lowBillet")
	public String lowBillet(ModelMap model,@RequestParam("paymentId")Long paymentId){
		Long studentId = fiancialFacade.updatePayment(paymentId);
		return newPaymentView(model, studentId);
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
