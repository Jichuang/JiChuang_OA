package org.jichuang.hope6537.base.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.base.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("postService")
public class PostServiceImpl extends BaseServiceImpl<Post> implements
        PostService {
    @Autowired
    @Qualifier(value = "postDao")
    @Override
    public void setDao(BaseDao<Post> dao) {
        super.setDao(dao);
    }

}
