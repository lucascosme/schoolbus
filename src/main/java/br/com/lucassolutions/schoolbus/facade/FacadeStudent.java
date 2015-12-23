package br.com.lucassolutions.schoolbus.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lucassolutions.schoolbus.model.School;
import br.com.lucassolutions.schoolbus.service.ServiceStudent;

@Component
public class FacadeStudent {

	@Autowired ServiceStudent serviceStudent;
	
	public List<School> getSchools() {
		List<School> schools = serviceStudent.getSchools();
		return schools;
	}

}
