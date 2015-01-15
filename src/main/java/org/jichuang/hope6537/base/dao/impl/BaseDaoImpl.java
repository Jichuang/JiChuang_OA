package org.jichuang.hope6537.base.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jichuang.hope6537.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 * <p>Describe: 持久层通用增删改成业务类</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月14日下午1:22:17</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<?> clz;

    private Logger logger = Logger.getLogger(getClass() + "DataBase Service");

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        clz = (Class<?>) type.getActualTypeArguments()[0];
    }

    public T selectEntryFromPrimaryKey(Serializable id) {
        try {
            return (T) sessionFactory.getCurrentSession().get(clz, id);
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            T t = (T) session.get(clz, id);
            session.close();
            logger.error("Open Session Closed");
            return t;
        }
    }

    public int insertEntry(T t) {
        try {
            sessionFactory.getCurrentSession().save(t);
            return 1;
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            session.save(t);
            session.close();
            logger.error("Open Session Closed");
            return 0;
        }
    }

    public int updateEntryByObject(T t) {
        try {
            sessionFactory.getCurrentSession().update(t);
            return 1;
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            session.update(t);
            session.close();
            logger.error("Open Session Closed");
            return 0;
        }
    }

    public int deleteEntryByPrimaryKey(Serializable id) {
        try {
            T t = this.selectEntryFromPrimaryKey(id);
            sessionFactory.getCurrentSession().delete(t);
            return 1;
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            T t = this.selectEntryFromPrimaryKey(id);
            session.delete(t);
            session.close();
            logger.error("Open Session Closed");
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> selectEntryAll() {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from " + clz.getSimpleName()).list();
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            List list = session
                    .createQuery("from " + clz.getSimpleName()).list();
            session.close();
            logger.error("Open Session Closed");
            return list;

        }

    }

    public int doQueryByHql(String hql) {
        try {
            return sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            int res = session.createQuery(hql).executeUpdate();
            session.close();
            logger.error("Open Session Closed");
            return res;
        }

    }

    public int doQueryBySql(String sql) {
        try {
            return sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            int res = session.createSQLQuery(sql).executeUpdate();
            session.close();
            logger.error("Open Session Closed");
            return res;
        }

    }

    @SuppressWarnings("unchecked")
    public List<T> selectEntryByHQL(String hql) {
        List<T> list = new ArrayList<T>();
        try {
            list = sessionFactory.getCurrentSession().createQuery(hql).list();
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            list = session.createQuery(hql).list();
            session.close();
            logger.error("Open Session Closed");
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<T> selectEntryBySQL(String sql) {
        List<T> list = new ArrayList<T>();
        try {
            list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
        } catch (Exception e) {
            Session session = sessionFactory.openSession();
            logger.error("Open Session");
            list = session.createSQLQuery(sql).list();
            session.close();
            logger.error("Open Session Closed");
        }
        return list;
    }

}
