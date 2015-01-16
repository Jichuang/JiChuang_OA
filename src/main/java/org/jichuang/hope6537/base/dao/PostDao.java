package org.jichuang.hope6537.base.dao;

import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.model.Post;

import java.util.List;

public interface PostDao extends BaseDao<Post> {

    List<Post> getPostsByMember(Member member);

    public boolean updateRoles4PostById(Post post);

    public boolean updateRoles4PostById(String[] roles, String postId);

    public boolean deletePostRoles(String postId);
}
