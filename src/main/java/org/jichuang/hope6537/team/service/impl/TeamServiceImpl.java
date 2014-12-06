package org.jichuang.hope6537.team.service.impl;


import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.team.service.TeamService;
import org.jichuang.hope6537.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    public List<Team> selectTeamListByMember(Member member) throws MemberException {
        if (member == null) {
            throw new MemberException("用户对象为空");
        } else {
            List<Team> teamList = new ArrayList<Team>();
            teamList.addAll(member.getTeamId());
            return teamList;
        }
    }


    @Override
    public List<Team> selectTeamListByStatus(Status status) {
        if (status == null) {
            return null;
        } else {
            return this.selectEntryByHQL("from Team where status = '" + status + "'");
        }
    }
}
