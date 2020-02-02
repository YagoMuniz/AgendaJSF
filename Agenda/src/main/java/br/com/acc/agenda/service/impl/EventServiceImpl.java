package br.com.acc.agenda.service.impl;

import br.com.acc.agenda.model.Agenda;
import br.com.acc.agenda.model.Event;
import br.com.acc.agenda.repository.EventRepository;
import br.com.acc.agenda.service.EventService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EventServiceImpl extends GenericServiceImpl<Event, Long> implements EventService {

    @EJB
    private EventRepository repo;

    @Override
    public List<Event> findAll() {
        return repo.findAll();
    }

    @Override
    public Event findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Event save(Event obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public Event update(Event obj) {
        return repo.update(obj);
    }

    @Override
    public List<Event> findByAgendaId(Long id) {
        return repo.findByAgendaId(id);
    }
}
