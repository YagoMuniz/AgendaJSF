package br.com.acc.agenda.repository.impl;

import br.com.acc.agenda.model.Event;
import br.com.acc.agenda.repository.EventRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class EventRepositoryImpl extends GenericRepositoryImpl<Event, Long> implements EventRepository {

    @PersistenceContext(unitName = "agenda-acc")
    protected EntityManager entityManager;

    @Override
    public List<Event> findByAgendaId(Long id) {
        TypedQuery<Event> query = entityManager.createQuery("select e from Event e where e.agenda.id=:id", Event.class)
                .setParameter("id", id);

        try{
            return query.getResultList();
        } catch (PersistenceException pe){
            return null;
        }
    }
}
