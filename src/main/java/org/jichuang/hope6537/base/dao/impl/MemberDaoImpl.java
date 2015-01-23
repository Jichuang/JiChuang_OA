package org.jichuang.hope6537.base.dao.impl;

import org.jichuang.hope6537.base.dao.MemberDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.utils.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDao")
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<Member> selectEntryAll() {
        return sessionFactory.getCurrentSession().createQuery("from Member").list();
    }

    @Override
    public Member selectLogin(Member member) {
        List<Member> list = super.selectEntryByHQL("from Member where username = '" + member.getUsername() + "'");
        for (Member selectedMember : list) {
            if (selectedMember.getPassword().equals(member.getPassword())) {
                return selectedMember;
            }
        }
        return null;
    }

    @Override
    public List<Member> selectMemberListByName(String name) {
        List<Member> memberList = this.selectEntryByHQL("from Member where name like '%" + name + "%'");
        return memberList;
    }

    @Override
    public List<Member> selectMemberListByTeam(Team team) {
        List<Member> memberList = this.selectEntryByHQL("select m from Member m , Team t , Member_Team mt where mt.teamId = t.teamId  and m.memberId = mt.memberId and t.teamId = " + team.getTeamId() + " and m.status ='" + Status.正常 + "'");
        return memberList;
    }
}
