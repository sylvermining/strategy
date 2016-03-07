package com.silvermining.demo.dao.parent.impl;

import com.silvermining.demo.dao.parent.GenericDAO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.StringUtils;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public abstract class GenericDAOImpl<T, PK extends Serializable> extends
		HibernateDaoSupport implements GenericDAO<T, PK> {

	private static final Logger LOGGER = Logger.getLogger(GenericDAOImpl.class);

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void insert(T t) {
		getHibernateTemplate().persist(t);
	}

	public T findByPK(PK id) {
		return (T) getSession().get(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> entities = new ArrayList<T>();
		try {
			entities = getHibernateTemplate().loadAll(persistentClass);
		} catch (Exception e) {
            LOGGER.info("Inernal Error");
            LOGGER.error(e.getStackTrace());
		}
		return entities;
	}

	public void remove(T t) {
		getHibernateTemplate().delete(t);
	}

	public void update(T object) {
		getHibernateTemplate().update(object);
	}

	public boolean exists(PK id) {
		Object entity = getHibernateTemplate().load(this.persistentClass, id);
		return (entity != null);
	}

	public T save(T object) {
		getHibernateTemplate().saveOrUpdate(object);
		return object;
	}

	public Object findObjectByPK(Object id, Class<?> clazz) {
		return getHibernateTemplate().get(clazz, (Serializable) id);
	}

	public List<?> getAllObject(Class<?> clazz) {
        StringBuilder query = generateSelectQuery(clazz);
        LOGGER.debug("query :: " + query.toString());
		return getHibernateTemplate().find(query.toString());
	}

	public List<?> getAllObject(Class<?> clazz, String varOrden) {
        StringBuilder query = generateSelectQuery(clazz);
        query = appendOrderByToQuery(query, varOrden);
        LOGGER.debug("query :: " + query.toString());
		return  getHibernateTemplate().find(query.toString());
	}

	public List<?> getAllObject(Class<?> clazz, String varOrden, int numResultados) {
        StringBuilder query = generateSelectQuery(clazz);
        query = appendOrderByToQuery(query, varOrden);
        LOGGER.debug("query :: " + query.toString());
		return getSession()
				.createQuery(query.toString())
				.setMaxResults(numResultados).list();
	}

	public void removeObject(Object object) {
		getHibernateTemplate().delete(object);
	}

	public Object saveObject(Object object) {
		getHibernateTemplate().saveOrUpdate(object);
		return object;
	}

	public void saveCollection(Collection col) {
		for (Object obj : col) {
			getHibernateTemplate().saveOrUpdate(obj);
		}
	}

	public Session getHibernateSession() {
		return getSessionFactory().getCurrentSession();
	}

    private StringBuilder generateSelectQuery(Class<?> clazz) {
        return new StringBuilder("from " + clazz.getSimpleName());
    }

    private StringBuilder appendOrderByToQuery(StringBuilder query, String parameter) {
        if (StringUtils.isEmpty(parameter)) {
            query.append(" c order by c." + parameter);
        }
        return query;
    }

    public void insertObject(Object object) {
        // TODO Auto-generated method stub
    }
}
