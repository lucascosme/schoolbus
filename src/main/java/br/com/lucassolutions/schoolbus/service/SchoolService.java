package br.com.lucassolutions.schoolbus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.SchoolDao;
import br.com.lucassolutions.schoolbus.model.School;

@Service
public class SchoolService {

	@Autowired SchoolDao schoolDao;
	
	public void saveSchool(String schoolName, String telephone, String directorName, String street, String neighborhood,
			String city) {
		
		School school = new School();
		school.setSchoolName(schoolName);
		school.setTelephone(telephone);
		school.setDirectorName(directorName);
		school.setStreet(street);
		school.setNeighborhood(neighborhood);
		school.setCity(city);
		
		schoolDao.save(school);
	}
}
