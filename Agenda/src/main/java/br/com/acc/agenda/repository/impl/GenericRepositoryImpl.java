package br.com.acc.agenda.repository.impl;

import br.com.acc.agenda.model.Base;
import br.com.acc.agenda.repository.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericRepositoryImpl<T extends Base<K>, K extends Serializable> implements GenericRepository<T, K> {

    @PersistenceContext(unitName = "agenda-acc")
    protected EntityManager entityManager;

    private Class<T> typeClass;

    public GenericRepositoryImpl() {
        this.typeClass = (Class<T>) getTypeClass();
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> query = this.getCriteriaBuilder().createQuery(typeClass);
        return entityManager.createQuery(query.select(query.from(typeClass))).getResultList();
    }

    @Override
    public T findById(K id) {
        return entityManager.find(typeClass, id);
    }

    @Override
    public T save(T obj) {

        if (obj.getId() == null) {
            entityManager.persist(obj);
            return obj;
        }

        return entityManager.merge(obj);
    }

    @Override
    public void delete(K id) {
        T obj = findById(id);
        entityManager.remove(obj);
    }

    @Override
    public T update(T obj) {
        return save(obj);
    }

    private Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}