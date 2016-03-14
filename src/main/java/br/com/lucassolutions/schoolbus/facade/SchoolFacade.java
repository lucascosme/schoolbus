package br.com.lucassolutions.schoolbus.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.service.SchoolService;

@Component
public class SchoolFacade {
	
	@Autowired SchoolService schoolService;

	public void saveSchool(String schoolName, String telephone, String directorName, String street, String neighborhood,
			String city) {
		schoolService.saveSchool(schoolName,telephone,directorName,street,neighborhood,city);
	}

}
