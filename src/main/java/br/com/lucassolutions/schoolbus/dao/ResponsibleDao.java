package br.com.lucassolutions.schoolbus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.lucassolutions.schoolbus.model.Responsible;
import br.com.lucassolutions.schoolbus.model.ResponsibleStatus;

@Repository
public class ResponsibleDao extends HibernateGenericDao<Responsible> {

	public ResponsibleDao(){
		super(Responsible.class);
	}
	
	public List<Responsible> findByNameAndStatusWithLike(String name,ResponsibleStatus...responsibleStatus) {
		List<Criterion> criterions = new ArrayList<>();
		criterions.add(
			Restrictions.and(
			Restrictions.ilike("name", name, MatchMode.START),
			Restrictions.in("status", responsibleStatus)));
		return findByCriterion(criterions);
	}
}
