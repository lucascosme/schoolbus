package br.com.lucassolutions.schoolbus.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.PaymentStatus;

@Component
public class DateHelper {
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DDMMYYYY = "dd/MM/yyyy";
	public static final String UUUU_MM_DD = "uuuu-MM-dd";
	
	public PaymentStatus paymentStatus(LocalDate paymentDate){
		if (paymentDate.isBefore(LocalDate.now())){
			return PaymentStatus.OPENED;
		}else{
			return PaymentStatus.FINALIZED;
		}
	}
	
	public String convertLocalDateInString(LocalDate localDate){
		DateTimeFormatter converter = DateTimeFormatter.ofPattern(DDMMYYYY);
		String dateFormated = localDate.format(converter);
		return dateFormated;
	}
	
	public LocalDate addOneMonth(LocalDate paymentDate){
		return paymentDate.plusMonths(1);
	}
}
