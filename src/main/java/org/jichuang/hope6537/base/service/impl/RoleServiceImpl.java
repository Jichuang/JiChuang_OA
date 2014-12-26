package org.jichuang.hope6537.base.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.model.Role;
import org.jichuang.hope6537.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
        RoleService {
    @Autowired
    @Qualifier(value = "roleDao")
    @Override
    public void setDao(BaseDao<Role> dao) {
        super.setDao(dao);
    }

    @Override
    public int insertRole(String des, String type) {
        if (des == null) {
            return 0;
        } else {
            Role role = new Role();
            role.setDes(des);
            role.setType(type);
            role.setStatus("正常");
            return this.insertEntry(role);
        }
    }
}
