package br.com.acc.agenda.service;

import br.com.acc.agenda.model.Person;

import javax.ejb.Local;

@Local
public interface PersonService extends GenericService<Person, Long>{
    Person findByEmailAndPassword(String email, String password);
}
