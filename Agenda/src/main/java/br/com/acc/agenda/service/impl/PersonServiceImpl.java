package br.com.acc.agenda.service.impl;

import br.com.acc.agenda.model.Agenda;
import br.com.acc.agenda.model.Person;
import br.com.acc.agenda.repository.PersonRepository;
import br.com.acc.agenda.service.PersonService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PersonServiceImpl extends GenericServiceImpl<Person, Long> implements PersonService {

    @EJB
    private PersonRepository repo;

    @Override
    public List<Person> findAll() {
        return repo.findAll();
    }

    @Override
    public Person findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Person save(Person obj) {
        return repo.save(obj);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public Person update(Person obj) {
        return repo.update(obj );
    }

    @Override
    public Person findByEmailAndPassword(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }
}
