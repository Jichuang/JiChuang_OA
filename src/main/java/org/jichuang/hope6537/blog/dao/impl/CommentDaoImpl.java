package org.jichuang.hope6537.blog.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.blog.dao.BlogDao;
import org.jichuang.hope6537.blog.dao.CommentDao;
import org.jichuang.hope6537.blog.model.Blog;
import org.jichuang.hope6537.blog.model.Comment;
import org.springframework.stereotype.Repository;

@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao {

}
