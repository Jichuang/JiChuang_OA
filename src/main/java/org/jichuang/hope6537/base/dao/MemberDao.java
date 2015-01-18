package org.jichuang.hope6537.base.dao;

import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.team.model.Team;

import java.util.List;

public interface MemberDao extends BaseDao<Member> {

    public Member selectLogin(Member member);

    public List<Member> selectMemberListByName(String name);

    public List<Member> selectMemberListByTeam(Team team);

}
