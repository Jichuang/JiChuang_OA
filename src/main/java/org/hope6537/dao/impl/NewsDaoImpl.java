package org.hope6537.dao.impl;

import org.hope6537.dao.NewsDao;
import org.hope6537.model.News;
import org.springframework.stereotype.Repository;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

}
