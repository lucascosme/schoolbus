package br.com.lucassolutions.schoolbus.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.Responsible;
import br.com.lucassolutions.schoolbus.service.ResponsibleService;

@Component
public class ResponsibleFacade {
	
	@Autowired ResponsibleService responsibleService;

	public List<Responsible> getResponsibles(String name) {
		return responsibleService.getResponsibles(name);
	}

}
