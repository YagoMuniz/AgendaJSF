package br.com.acc.agenda.repository;

import br.com.acc.agenda.model.Person;

import javax.ejb.Local;

@Local
public interface PersonRepository extends GenericRepository<Person, Long> {

    Person findByEmailAndPassword(String email, String password);

}
