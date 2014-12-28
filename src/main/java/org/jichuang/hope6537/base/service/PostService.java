package org.jichuang.hope6537.base.service;

import org.jichuang.hope6537.base.model.Post;
import org.jichuang.hope6537.base.model.Role;

import java.util.List;

public interface PostService extends BaseService<Post> {

    int insertPost(String des, boolean isID);

    int updateRoles4PostById(String[] roles, String postId);

    List<Role> selectRolesByPostId(String postId);

    int updateRoles4PostById(Post post, String[] oldRoles, String[] newRoles, String postId);

    int deletePostRoles(String postId);

}
