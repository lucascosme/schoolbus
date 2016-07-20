package br.com.lucassolutions.schoolbus.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.service.FiancialService;

@Component
public class BilletGenerator {

	@Autowired FiancialService fiancialService;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void Generator(){
		fiancialService.BilletGenerator();
	}
}
