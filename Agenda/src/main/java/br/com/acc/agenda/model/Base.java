package br.com.acc.agenda.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class Base<K extends Serializable> implements Serializable {


    private static final long serialVersionUID = 1L;

    public abstract K getId();

}
