package br.com.gerenciador.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.gerenciador.util.MessageView;

public abstract class GenericBean<T> {
	public abstract GenericService<T> getService();

	public abstract T getEntity();

	protected List<T> list = new ArrayList<T>();

	public void filter() {
		setList(getService().filter(getEntity()));
	}

	public Page<T> findAll(Pageable arg0) {
		return getService().findAll(arg0);
	}

	public long count() {
		return getService().count();
	}

	public void delete() {
		getService().delete(getEntity());
		setList(getAll());
	}

	public void deleteAll() {
		getService().deleteAll();
	}

	public void save() {
		getService().save(getEntity());
		setList(getAll());

		MessageView.info(getSaveMessage());
	}

	private String getSaveMessage() {
		return "Entidade salva com sucesso!";
	}

	public List<T> getAll() {
		return getService().findAll();
	}

	public List<T> findAll(Sort paramSort) {
		return getService().findAll(paramSort);
	}

	public List<T> findAll(Iterable<Serializable> ids) {
		return getService().findAll(ids);
	}

	public <S extends T> List<S> save(Iterable<S> paramIterable) {
		return getService().save(paramIterable);
	}

	public void flush() {
		getService().flush();
	}

	public T saveAndFlush() {
		return getService().saveAndFlush(getEntity());
	}

	public void deleteAllInBatch() {
		getService().deleteAllInBatch();
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
