package br.com.lucassolutions.schoolbus.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;

public class DateHelper {
	
	private static final String ṔERIOD = "00 00 00 * * *";

	public static void main(String[] args) {
		
	LocalDate dataPagamento = LocalDate.of(2015, 12, 29);
	
	//Formatando a data para o padrão brasileiro
	LocalDate hoje = LocalDate.now();
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String format = hoje.format(formatador);
	
	//Verificação de pagamentos
	if (dataPagamento.isBefore(hoje)){
		System.out.println("Pagamento em atraso");
	}else{
		System.out.println("Pagamento em dia");
	}
	}
	
	@Scheduled(cron=ṔERIOD)
	public LocalDate addMoreOneMonth(LocalDate datePayment){
		LocalDate nextPayment = datePayment.plusMonths(1);
	return nextPayment;
	}
	
	

}
