package br.com.lucassolutions.schoolbus.dao;

import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.School;

@Repository
public class SchoolDao extends HibernateGenericDao<School>{
	
	public SchoolDao(){
		super(School.class);
	}

}
