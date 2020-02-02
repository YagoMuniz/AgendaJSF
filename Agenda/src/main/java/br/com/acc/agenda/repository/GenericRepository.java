package br.com.acc.agenda.repository;

import br.com.acc.agenda.model.Base;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T extends Base<K>, K extends Serializable> {

    List<T> findAll();
    T findById(K id);
    T save(T obj);
    void delete(K id);
    T update(T obj);

}
