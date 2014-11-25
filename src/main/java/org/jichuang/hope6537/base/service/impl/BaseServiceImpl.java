package org.jichuang.hope6537.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<T> implements BaseService<T> {

	public String text;

	protected BaseDao<T> dao;

	public BaseDao<T> getDao() {
		return dao;
	}

	@Autowired
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hope6537.service.BaseService#selectEntryFromPrimaryKey(java.io.
	 * Serializable)
	 * 
	 * @Change:Hope6537
	 */
	public T selectEntryFromPrimaryKey(Serializable id) {
		return dao.selectEntryFromPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hope6537.service.BaseService#insertEntry(java.lang.Object)
	 * 
	 * @Change:Hope6537
	 */
	public int insertEntry(T t) {
		return dao.insertEntry(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hope6537.service.BaseService#updateEntryByObject(java.lang.Object)
	 * 
	 * @Change:Hope6537
	 */
	public int updateEntryByObject(T t) {
		return dao.updateEntryByObject(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hope6537.service.BaseService#deleteEntryByPrimaryKey(java.io.Serializable
	 * )
	 * 
	 * @Change:Hope6537
	 */
	public int deleteEntryByPrimaryKey(Serializable id) {
		return dao.deleteEntryByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hope6537.service.BaseService#selectEntryAll()
	 * 
	 * @Change:Hope6537
	 */
	public List<T> selectEntryAll() {
		return dao.selectEntryAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hope6537.service.BaseService#selectEntryByHQL(java.lang.String)
	 * 
	 * @Change:Hope6537
	 */
	public List<T> selectEntryByHQL(String hql) {
		return dao.selectEntryByHQL(hql);
	}

}
