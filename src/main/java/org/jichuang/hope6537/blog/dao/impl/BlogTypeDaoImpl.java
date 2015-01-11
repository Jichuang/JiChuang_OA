package org.jichuang.hope6537.blog.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.blog.dao.BlogTypeDao;
import org.jichuang.hope6537.blog.model.BlogType;
import org.springframework.stereotype.Repository;

@Repository("blogTypeDao")
public class BlogTypeDaoImpl extends BaseDaoImpl<BlogType> implements BlogTypeDao {
}
