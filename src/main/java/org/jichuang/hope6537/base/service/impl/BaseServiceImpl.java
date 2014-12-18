package org.jichuang.hope6537.base.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

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

    public T selectEntryFromPrimaryKey(Serializable id) {
        return dao.selectEntryFromPrimaryKey(id);
    }

    public int insertEntry(T t) {
        return dao.insertEntry(t);
    }

    public int updateEntryByObject(T t) {
        return dao.updateEntryByObject(t);
    }

    public int deleteEntryByPrimaryKey(Serializable id) {
        return dao.deleteEntryByPrimaryKey(id);
    }

    public List<T> selectEntryAll() {
        return dao.selectEntryAll();
    }

    public List<T> selectEntryByHQL(String hql) {
        return dao.selectEntryByHQL(hql);
    }

    @Override
    public int doQueryByHql(String hql) {
        return dao.doQueryByHql(hql);
    }


}
