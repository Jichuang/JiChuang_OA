package org.jichuang.hope6537.base.service.impl;


import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.team.dao.Member_TeamDao;
import org.jichuang.hope6537.team.dao.TeamTypeDao;
import org.jichuang.hope6537.team.model.Member_Team;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.team.model.TeamType;
import org.jichuang.hope6537.team.service.TeamService;
import org.jichuang.hope6537.utils.DateFormat_Jisuan;
import org.jichuang.hope6537.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    private TeamTypeDao teamTypeDao;

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
                ids.append(" teamId = ");
                ids.append(member_teams.get(i).getTeamId().getTeamId());
                if (i < member_teams.size() - 1) {
                    ids.append(" OR ");
                }
            }
            String hql = "from Team where " + ids.toString();
            List<Team> teamList = dao.selectEntryByHQL(hql);
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

    @Override
    public int insertTeam(Team team, Member member, String teamTypeId) {
        JSONObject info = new JSONObject();
        TeamType teamType = teamTypeDao.selectEntryFromPrimaryKey(Integer.parseInt(teamTypeId));
        info.put("version", "0.1-SNAPSHOT");
        team.setTeamTypeId(teamType);
        team.setDate(DateFormat_Jisuan.createNowTime());
        team.setStatus(Status.待审核.toString());
        team.setInfo(info.toJSONString());
        int res1 = this.insertEntry(team);
        Member_Team member_team = new Member_Team();
        member_team.setMemberId(member);
        member_team.setTeamId(team);
        int res2 = member_teamDao.insertEntry(member_team);
        int res = res1 | res2;
        return res;
    }

    @Override
    public int deleteTeam(String teamId, Member member) {
        try {
            List<Member_Team> list = member_teamDao.selectEntryByHQL("from Member_Team where teamId = " + teamId + " and memberId = " + member.getMemberId());
            if (list == null || list.isEmpty()) {
                return -1;
            } else {
                int res1 = member_teamDao.doQueryByHql("delete from Member_Team where teamId =" + teamId);
                int res2 = this.deleteEntryByPrimaryKey(Integer.parseInt(teamId));
                return res1 + res2;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
