package br.com.lucassolutions.schoolbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucassolutions.schoolbus.dao.ResponsibleDao;
import br.com.lucassolutions.schoolbus.model.Responsible;
import br.com.lucassolutions.schoolbus.model.ResponsibleStatus;

@Service
public class ResponsibleService {

	@Autowired ResponsibleDao responsibleDao;
	
	public List<Responsible> getResponsibles(String name) {
		return responsibleDao.findByNameAndStatusWithLike(name, ResponsibleStatus.ACTIVE);
	}

}
