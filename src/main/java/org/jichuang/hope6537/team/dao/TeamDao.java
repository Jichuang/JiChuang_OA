package org.jichuang.hope6537.team.dao;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.utils.Status;

import java.util.List;

public interface TeamDao extends BaseDao<Team> {

    public List<Team> selectTeamListByMember(Member member) throws MemberException;

    public List<Team> selectTeamListByStatus(Status status);

    public int deleteTeam(String teamId, Member member);

}
