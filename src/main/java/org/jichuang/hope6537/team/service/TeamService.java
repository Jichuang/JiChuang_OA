package org.jichuang.hope6537.team.service;

import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.utils.Status;

import java.util.List;

public interface TeamService extends BaseService<Team> {

    List<Team> selectTeamListByMember(Member member) throws MemberException;

    List<Team> selectTeamListByStatus(Status status);

    int insertTeam(Team team, Member member);

    int deleteTeam(String teamId, Member member);

    int updateTeam(Team team, Member member);


}
