package org.jichuang.hope6537.blog.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.blog.dao.BlogDao;
import org.jichuang.hope6537.blog.model.Blog;
import org.springframework.stereotype.Repository;

@Repository("blogDao")
public class BlogDaoImpl extends BaseDaoImpl<Blog> implements BlogDao {

}
