package br.com.lucassolutions.schoolbus.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.facade.FiancialFacade;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.util.DateHelper;

@Controller
@RequestMapping("/controller/user")
public class FinancialController {
	
	@Autowired private FiancialFacade fiancialFacade;
	@Autowired private PaymentDao paymentDao;
	
	@RequestMapping("/showPaymentView")
	public String showPaymentView(ModelMap model){
		return "showPayment";
	}
	
	@RequestMapping(value="/searchStudent", method=RequestMethod.POST)
	public String searchStudent(ModelMap model,@RequestParam("name") String name){
		List<Student> listStudents = fiancialFacade.searchStudentName(name);
		model.addAttribute("listStudents", listStudents);
		return showPaymentView(model);
	}
	
	@RequestMapping("/newPaymentView")
	public String newPaymentView(ModelMap model,@RequestParam("studentId")Long studentId){
		Payment payment = fiancialFacade.getPayment(studentId);
		model.addAttribute("payment", payment);
		return "newPayment";
	}
	
	@RequestMapping("/balanceView")
	public String balanceView(ModelMap model){
		return "balance";
	}
	
	@RequestMapping("/balanceCalc")
	public String balanceCalc(ModelMap model,@RequestParam("startDate")@DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate startDate,
			@RequestParam("endDate")@DateTimeFormat(pattern = DateHelper.UUUU_MM_DD) LocalDate endDate){
		Collection<Payment> payments = paymentDao.findByDate(startDate,endDate,PaymentStatus.FINALIZED);
		model.addAttribute("payments", payments);
		return balanceView(model);
	}
}