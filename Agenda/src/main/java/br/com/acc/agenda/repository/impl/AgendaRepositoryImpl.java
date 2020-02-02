package br.com.acc.agenda.repository.impl;

import br.com.acc.agenda.model.Agenda;
import br.com.acc.agenda.repository.AgendaRepository;

import javax.ejb.Stateless;

@Stateless
public class AgendaRepositoryImpl extends GenericRepositoryImpl<Agenda, Long> implements AgendaRepository { }
