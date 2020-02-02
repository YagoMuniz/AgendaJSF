package br.com.acc.agenda.service.impl;

import br.com.acc.agenda.model.Agenda;
import br.com.acc.agenda.repository.AgendaRepository;
import br.com.acc.agenda.service.AgendaService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AgendaServiceImpl extends GenericServiceImpl<Agenda, Long> implements AgendaService {

    @EJB
    private AgendaRepository repo;

    @Override
    public List<Agenda> findAll() {
        return repo.findAll();
    }

    @Override
    public Agenda findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Agenda save(Agenda obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public Agenda update(Agenda obj) {
        return repo.update(obj );
    }
}
