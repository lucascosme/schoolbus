package br.com.lucassolutions.schoolbus.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="reminders")
public class Reminder extends DomainModel{

	private static final long serialVersionUID = 1L;

}
