package org.jichuang.hope6537.blog.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.blog.model.Comment;
import org.jichuang.hope6537.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements
        CommentService {
    @Autowired
    @Qualifier(value = "commentDao")
    @Override
    public void setDao(BaseDao<Comment> dao) {
        super.setDao(dao);
    }

}
