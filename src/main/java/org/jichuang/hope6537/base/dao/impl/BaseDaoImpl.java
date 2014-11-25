package org.jichuang.hope6537.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.jichuang.hope6537.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 *<pre>
 *
 *</pre>
 * <p>Describe: 持久层通用增删改成业务类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月14日下午1:22:17</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<?> clz;

	@Autowired(required = true)
	protected SessionFactory sessionFactory;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clz = (Class<?>) type.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public T selectEntryFromPrimaryKey(Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clz, id);
	}

	public int insertEntry(T t) {
		try {
			sessionFactory.getCurrentSession().save(t);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateEntryByObject(T t) {
		try {
			sessionFactory.getCurrentSession().update(t);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteEntryByPrimaryKey(Serializable id) {
		try {
			T t = this.selectEntryFromPrimaryKey(id);
			sessionFactory.getCurrentSession().delete(t);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<T> selectEntryAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from" + clz.getSimpleName()).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> selectEntryByHQL(String hql) {
		List<T> list = new ArrayList<T>();
		list = sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

}
