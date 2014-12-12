package org.jichuang.hope6537.base.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

    /**
     * <p>Describe: 通过主键来寻找实体对象</p>
     * <p>Using: session.get(class clz , int id)</p>
     * <p>How To Work: 直接调用就可以了</p>
     * <p>DevelopedTime: 2014年10月14日下午1:23:46 </p>
     * <p>Author:Hope6537</p>
     *
     * @param id
     * @return
     * @see
     */
    T selectEntryFromPrimaryKey(Serializable id);

    /**
     * <p>Describe: 添加一个实体对象的持久化操作</p>
     * <p>Using: session.save()</p>
     * <p>How To Work: 直接调用就可以了，给对象</p>
     * <p>DevelopedTime: 2014年10月14日下午1:24:27 </p>
     * <p>Author:Hope6537</p>
     *
     * @param t
     * @return
     * @see
     */
    int insertEntry(T t);

    /**
     * <p>Describe: 通过该对象的id进行数据对象的持久化更新</p>
     * <p>Using: 即session.update</p>
     * <p>How To Work: 直接调用就可以了，给对象</p>
     * <p>DevelopedTime: 2014年10月14日下午1:24:41 </p>
     * <p>Author:Hope6537</p>
     *
     * @param t
     * @return
     * @see
     */
    int updateEntryByObject(T t);

    /**
     * <p>Describe: 通过该对象id进行数据对象的持久化的删除</p>
     * <p>Using: session.delete()</p>
     * <p>How To Work: 直接调用就可以了，给对象</p>
     * <p>DevelopedTime: 2014年10月14日下午1:25:02 </p>
     * <p>Author:Hope6537</p>
     *
     * @param id
     * @return
     * @see
     */
    int deleteEntryByPrimaryKey(Serializable id);

    /**
     * <p>Describe: 获得持久化层的全部对象</p>
     * <p>Using: session.createQuery()</p>
     * <p>How To Work: 直接调用就可以了</p>
     * <p>DevelopedTime: 2014年10月14日下午1:26:16 </p>
     * <p>Author:Hope6537</p>
     *
     * @return 返回所有对象
     * @see
     */
    List<T> selectEntryAll();

    /**
     * <p>Describe: 使用HQL的语句查询</p>
     * <p>Using: session.createQuery(String HQL)</p>
     * <p>How To Work: 输入HQL语句</p>
     * <p>DevelopedTime: 2014年10月14日下午1:26:58 </p>
     * <p>Author:Hope6537</p>
     *
     * @param hql HQL查询语句
     * @return 返回根据查询结果筛选出来的对象
     * @see
     */
    List<T> selectEntryByHQL(String hql);


    int doQueryByHql(String hql);

}
