package br.com.acc.agenda.service;

import br.com.acc.agenda.model.Base;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends Base<K>, K extends Serializable> extends Serializable{

    List<T> findAll();
    T findById(K id);
    T save(T obj);
    void delete(K id);
    T update(T obj);

}
