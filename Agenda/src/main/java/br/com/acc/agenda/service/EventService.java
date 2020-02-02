package br.com.acc.agenda.service;

import br.com.acc.agenda.model.Event;
import br.com.acc.agenda.model.Person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EventService extends GenericService<Event, Long>{
    List<Event> findByAgendaId(Long id);
}
