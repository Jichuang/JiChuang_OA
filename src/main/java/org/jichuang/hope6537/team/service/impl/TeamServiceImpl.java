package org.jichuang.hope6537.team.service.impl;


import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("teamService")
public class TeamServiceImpl extends BaseServiceImpl<Team> implements
		TeamService {

	// 使用这种方式能够有效的环节AutoWired无法识别bean的问题
	@Autowired
	@Qualifier("teamDao")
	@Override
	public void setDao(BaseDao<Team> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}

}
