package org.hope6537.service.impl;


import org.hope6537.dao.BaseDao;
import org.hope6537.model.Team;
import org.hope6537.service.TeamService;
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
