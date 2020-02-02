package br.com.acc.agenda.service;

import br.com.acc.agenda.model.Agenda;
import br.com.acc.agenda.model.Person;

import javax.ejb.Local;

@Local
public interface AgendaService extends GenericService<Agenda, Long>{ }
