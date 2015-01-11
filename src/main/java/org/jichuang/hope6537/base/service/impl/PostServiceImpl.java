package org.jichuang.hope6537.base.service.impl;

import org.jichuang.hope6537.base.dao.PostDao;
import org.jichuang.hope6537.base.dao.RoleDao;
import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.base.model.Role;
import org.jichuang.hope6537.base.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostServiceImpl extends BaseServiceImpl<Post> implements
        PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public int insertPost(String des, boolean isID) {
        Post post = new Post();
        post.setDes(des);
        post.setStatus("正常");
        int res = this.insertEntry(post);
        //在这里应该对事务进行提交
        return isID ? post.getPostId() : res;
    }

    public boolean updateRoles4PostById(String[] roles, String postId) {
        return postDao.updateRoles4PostById(roles, postId);
    }

    @Override
    public List<Role> selectRolesByPostId(String postId) {
        return roleDao.selectRolesByPostId(postId);
    }

    @Override
    public boolean updateRoles4PostById(Post post, String[] oldRoles, String[] newRoles, String postId) {
        return postDao.updateRoles4PostById(post, oldRoles, newRoles, postId);
    }

    @Override
    public boolean deletePostRoles(String postId) {
        return postDao.deletePostRoles(postId);
    }


}
