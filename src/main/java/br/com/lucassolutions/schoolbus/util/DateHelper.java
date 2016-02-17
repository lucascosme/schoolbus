package br.com.lucassolutions.schoolbus.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.scheduling.annotation.Scheduled;

public class DateHelper {
	
	private static final String ṔERIOD = "00 00 00 * * *";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DDMMYYYY = "dd/MM/yyyy";
	public static final String UUUU_MM_DD = "uuuu-MM-dd";
	
	public static void main(String[] args) {
		
	LocalDate dataPagamento = LocalDate.of(2016, 12, 29);
	
	DateHelper dateHelper = new DateHelper();
	String convertLocalDateInString = dateHelper.convertLocalDateInString(LocalDate.now());
	
	System.out.println("Data formatada é:" + convertLocalDateInString);
	
	//Verificação de pagamentos
	if (dataPagamento.isBefore(LocalDate.now())){
		System.out.println("Pagamento em atraso");
	}else{
		System.out.println("Pagamento em dia");
	}
	
	Month[] months = Month.values();
	
	for (Month month : months) {
		System.out.println(month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("PT-BT")));
	}
	
	Month mes = Month.MAY;
	System.out.println(mes);
	
	YearMonth yearMonth = YearMonth.of(2016, mes); 
	
	LocalDate initial = LocalDate.of(2016, 2, 1);
	LocalDate end = LocalDate.of(2016, 2, 25);
	
//	System.out.println(dateHelper.getDaysBetweenDates(initial, end));

	
	}
	
	public String convertLocalDateInString(LocalDate localDate){
		DateTimeFormatter converter = DateTimeFormatter.ofPattern(DDMMYYYY);
		String dateFormated = localDate.format(converter);
		return dateFormated;
	}
	
//	public List<LocalDate> getDaysBetweenDates(LocalDate startDate, LocalDate endDate){
//		List<LocalDate> totalDates = new ArrayList<>();
//		while (!startDate.isAfter(endDate)) {
//		    totalDates.add(startDate);
//		    startDate = startDate.plusDays(1);
//		}
//		return totalDates;
//	}
	
	
	@Scheduled(cron=ṔERIOD)
	public LocalDate addMoreOneMonth(LocalDate datePayment){
		LocalDate nextPayment = datePayment.plusMonths(1);
	return nextPayment;
	}
	
	public static LocalDate getLocalDate(String date, String dateFormat) {
		try {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
			return LocalDate.parse(date, dateTimeFormatter);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
