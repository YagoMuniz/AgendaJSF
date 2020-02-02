package br.com.acc.agenda.repository;

import br.com.acc.agenda.model.Event;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EventRepository extends GenericRepository<Event, Long> {

    List<Event> findByAgendaId(Long id);

}
