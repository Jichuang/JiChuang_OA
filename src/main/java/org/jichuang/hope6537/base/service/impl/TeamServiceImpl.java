package org.jichuang.hope6537.base.service.impl;


import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.team.dao.Member_TeamDao;
import org.jichuang.hope6537.team.model.Member_Team;
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
        super.setDao(dao);
    }

    @Autowired
    private Member_TeamDao member_teamDao;


    @Override
    public List<Team> selectTeamListByMember(Member member) throws MemberException {
        if (member == null) {
            throw new MemberException("用户对象为空");
        } else {
            List<Member_Team> member_teams = member_teamDao.selectEntryByHQL("from Member_Team where memberId = " + member.getMemberId());
            StringBuffer ids = new StringBuffer();
            for (int i = 0; i < member_teams.size(); i++) {
                ids.append(member_teams.get(i).getTeamId().getTeamId());
                if (i < member_teams.size() - 1) {
                    ids.append("||");
                }
            }
            List<Team> teamList = dao.selectEntryByHQL("from Team where teamId = " + ids.toString());
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
