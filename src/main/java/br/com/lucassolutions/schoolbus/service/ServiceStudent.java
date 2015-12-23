package br.com.lucassolutions.schoolbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.SchoolDao;
import br.com.lucassolutions.schoolbus.model.School;

@Service
public class ServiceStudent {
	
	@Autowired SchoolDao schoolDao;

	public List<School> getSchools() {
		List<School> schools = schoolDao.findAll();
		return schools;
	}
}