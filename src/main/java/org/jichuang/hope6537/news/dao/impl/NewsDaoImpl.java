package org.jichuang.hope6537.news.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.news.dao.NewsDao;
import org.jichuang.hope6537.news.model.News;
import org.springframework.stereotype.Repository;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

}
