package br.com.gerenciador.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public abstract class GenericService<T> {
	@SuppressWarnings("rawtypes")
	public abstract JpaRepository getRepository();

	@Autowired
	private EntityManager entityManager;

	public Page<T> findAll(Pageable arg0) {
		return getRepository().findAll(arg0);
	}

	public long count() {
		return getRepository().count();
	}

	public void delete(Serializable id) {
		getRepository().delete(id);
	}

	public void delete(T entity) {
		getRepository().delete(entity);
	}

	public void delete(Iterable<? extends T> entities) {
		getRepository().delete(entities);
	}

	public void deleteAll() {
		getRepository().deleteAll();
	}

	public boolean exists(Serializable id) {
		return getRepository().exists(id);
	}

	public T findOne(Serializable id) {
		return (T) getRepository().findOne(id);
	}

	public <S extends T> S save(S entity) {
		return (S) getRepository().save(entity);
	}

	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Transactional(readOnly = true)
	public List<T> filter(T param) {
		Session session = (Session) entityManager.getDelegate();

		prepareStrings(param);

		Criteria criteria = session.createCriteria(param.getClass());

		criteria.add(Example.create(param).enableLike().ignoreCase().excludeZeroes());

		return criteria.list();
	}

	public void prepareStrings(Object o) {
		for (Field f : o.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getType().equals(String.class)) {
					String value = (String) f.get(o);
					if (value != null && value.trim().isEmpty()) {
						f.set(o, null);
					} else if (value != null) {
						f.set(o, "%" + value + "%");
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<T> findAll(Sort paramSort) {
		return getRepository().findAll(paramSort);
	}

	public List<T> findAll(Iterable<Serializable> ids) {
		return getRepository().findAll(ids);
	}

	public <S extends T> List<S> save(Iterable<S> paramIterable) {
		return getRepository().save(paramIterable);
	}

	public void flush() {
		getRepository().flush();
	}

	public <S extends T> S saveAndFlush(S paramS) {
		return (S) getRepository().saveAndFlush(paramS);
	}

	public void deleteInBatch(Iterable<T> paramIterable) {
		getRepository().deleteInBatch(paramIterable);
	}

	public void deleteAllInBatch() {
		getRepository().deleteAllInBatch();
	}

	public T getOne(Serializable paramID) {
		return (T) getRepository().getOne(paramID);
	}
}
