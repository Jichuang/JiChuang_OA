package org.jichuang.hope6537.base.dao.impl;

import org.jichuang.hope6537.base.dao.RoleDao;
import org.jichuang.hope6537.base.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    @Override
    public List<Role> selectRolesByPostId(String postId) {
        String hql = "SELECT r.roleId , r.des , r.status ,r.type from Role r , Post_Role pr where pr.roleId = r.roleId and pr.postId = " + postId;
        return selectEntryByHQL(hql);
    }

}
