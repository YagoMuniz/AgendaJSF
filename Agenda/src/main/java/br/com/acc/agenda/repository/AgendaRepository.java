package br.com.acc.agenda.repository;

import br.com.acc.agenda.model.Agenda;

import javax.ejb.Local;

@Local
public interface AgendaRepository extends GenericRepository<Agenda, Long> { }
