package br.com.acc.agenda.service.impl;

import br.com.acc.agenda.model.Base;
import br.com.acc.agenda.service.GenericService;

import javax.ejb.Local;
import java.io.Serializable;

public abstract class GenericServiceImpl<T extends Base<K>, K extends Serializable> implements GenericService<T, K> {
}
