package org.jichuang.hope6537.base.dao;

import org.jichuang.hope6537.base.model.Role;

import java.util.List;

public interface RoleDao extends BaseDao<Role> {

    public List<Role> selectRolesByPostId(String postId);

}
