package org.jichuang.hope6537.team.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.team.dao.TeamDao;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.utils.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teamDao")
public class TeamDaoImpl extends BaseDaoImpl<Team> implements TeamDao {


    public List<Team> selectTeamListByMember(Member member) throws MemberException {
        if (member == null) {
            throw new MemberException("用户对象为空");
        } else {
            List<Team> teamList = this.selectEntryByHQL("select t from Team t , Member_Team mt " +
                    "where mt.teamId = t.teamId and mt.memberId = " + member.getMemberId());
            return teamList;
        }
    }

    public List<Team> selectTeamListByStatus(Status status) {
        if (status == null) {
            return null;
        } else {
            return this.selectEntryByHQL("from Team where status = '" + status + "'");
        }
    }

    public int deleteTeam(String teamId, Member member) {
        return this.doQueryBySql("delete t.* , mt.* from Team t , Member_Team mt where mt.teamId = t.teamId and mt.memberId = " + member.getMemberId() + " and t.teamId = " + teamId);
    }

}
