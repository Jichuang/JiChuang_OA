package org.hope6537.dao.impl;

import org.hope6537.dao.PostDao;
import org.hope6537.model.Post;
import org.springframework.stereotype.Repository;

@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

}
