package br.com.acc.agenda.repository.impl;

import br.com.acc.agenda.model.Person;
import br.com.acc.agenda.repository.PersonRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

@Stateless
public class PersonRepositoryImpl extends GenericRepositoryImpl<Person, Long> implements PersonRepository {

    @PersistenceContext(unitName = "agenda-acc")
    protected EntityManager entityManager;

    @Override
    public Person findByEmailAndPassword(String email, String password) {
        TypedQuery<Person> query = entityManager.createQuery(
                "select p from Person p where p.email=:email and password=:password", Person.class)
                .setParameter("email", email)
                .setParameter("password", password);

        try{
            return query.getSingleResult();
        } catch (PersistenceException pe){
            return null;
        }
    }
}
