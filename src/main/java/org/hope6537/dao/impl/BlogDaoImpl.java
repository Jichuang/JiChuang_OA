package org.hope6537.dao.impl;

import org.hope6537.dao.BlogDao;
import org.hope6537.model.Blog;
import org.springframework.stereotype.Repository;

@Repository("blogDao")
public class BlogDaoImpl extends BaseDaoImpl<Blog> implements BlogDao {

}
