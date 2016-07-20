package br.com.lucassolutions.schoolbus.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.ExpenseDao;
import br.com.lucassolutions.schoolbus.dao.PaymentDao;
import br.com.lucassolutions.schoolbus.dao.StudentDao;
import br.com.lucassolutions.schoolbus.model.Expense;
import br.com.lucassolutions.schoolbus.model.ExpenseStatus;
import br.com.lucassolutions.schoolbus.model.Payment;
import br.com.lucassolutions.schoolbus.model.PaymentStatus;
import br.com.lucassolutions.schoolbus.model.Student;
import br.com.lucassolutions.schoolbus.model.StudentStatus;

@Service
public class FiancialService {

	private static final long ONE = 1L;
	@Autowired private PaymentDao paymentDao;
	@Autowired private ExpenseDao expenseDao;
	@Autowired private StudentDao studentDao;
	
	public Collection<Student> searchStudentName(String name) {
		 Collection<Student> students = studentDao.findByStatusAndStudentNameAndStatusPayment(name, PaymentStatus.OPENED);
		 return students.stream().filter(distinctByKey(s -> s.getName())).collect(Collectors.toList());
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
		Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	public Collection<Payment> getPaymentByStudentId(Long studentId) {
		return paymentDao.findByStatusAndStudentId(studentId, PaymentStatus.OPENED);
	}

	public Collection<Payment> getPaymentsByRangeDate(LocalDate startDate,LocalDate endDate) {
		Collection<Payment> payments = paymentDao.findByDate(startDate,endDate,PaymentStatus.FINALIZED);
		return payments;
	}

	public Collection<Expense> getExpensesByRangeDate(LocalDate startDate, LocalDate endDate) {
		Collection<Expense> expenses = expenseDao.findByDate(startDate, endDate, ExpenseStatus.OPENED,ExpenseStatus.PAID_OUT);
		return expenses;
	}
	
	public double paymentSum(Collection<Payment> payments){
		return payments.stream().mapToDouble(p -> p.getValue()).sum();
	}
	
	public double expenseSum(Collection<Expense> expenses){
		return expenses.stream().mapToDouble(e -> e.getValue()).sum();
	}
	
	public double receivingLiquid(double payment, double expense){
		return payment-expense;
	}
	
	public void BilletGenerator(){
		List<Student> listStudentActive = studentDao.findByStatus(StudentStatus.ACTIVE);
		for (Student student : listStudentActive) {
			LocalDate paymentDate = student.getPaymentDate();
			if (paymentDate.isBefore(LocalDate.now())){
				Payment payment = new Payment();
				payment.setExpirationDate(paymentDate.plusMonths(ONE));
				payment.setLastPayment(LocalDate.now());
				payment.setStatus(PaymentStatus.OPENED);
				payment.setStudent(student);
				payment.setValue(student.getValuePayment());
				paymentDao.save(payment);
				studentDao.updatePaymentDate(student.getId(), paymentDate.plusMonths(ONE));
			};
		}
	}

	public Long updatePayment(Long paymentId) {
		Payment payment = paymentDao.findById(paymentId);
		paymentDao.updateStatusAndLastPayment(payment.getId(), PaymentStatus.FINALIZED,LocalDate.now());
		Long studentId = payment.getStudent().getId();
		return studentId;
	}
}