package org.jichuang.hope6537.team.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.team.model.TeamType;
import org.jichuang.hope6537.team.service.TeamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Zhaopeng-Rabook on 14-12-9.
 */
@Service("teamTypeService")
public class TeamTypeServiceImpl extends BaseServiceImpl<TeamType> implements TeamTypeService {

    @Autowired
    @Qualifier("teamTypeDao")
    @Override
    public void setDao(BaseDao<TeamType> dao) {
        super.setDao(dao);
    }
}
