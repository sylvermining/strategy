package com.silvermining.demo.dao.parent;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericDAO<T, PK extends Serializable> {

    List<T> getAll();
    List<?> getAllObject(Class<?> clazz);
    List<?> getAllObject(Class<?> clazz, String varOrden);
    List<?> getAllObject(Class<?> clazz, String varOrden, int numResultados);
    T findByPK(PK id);
    Object findObjectByPK(Object id, Class<?> clazz);
    void update(T object);
    void remove(T object);
    void removeObject(Object object);
    void insert(T object);
    void insertObject(Object object);
    boolean exists(PK paramPK);
    T save(T object);
    Object saveObject(Object object);
    void saveCollection(Collection col);
    Session getHibernateSession();
}
