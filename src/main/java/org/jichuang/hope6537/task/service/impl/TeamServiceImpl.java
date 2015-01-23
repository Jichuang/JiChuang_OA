package org.jichuang.hope6537.task.service.impl;


import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.dao.MemberDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.team.dao.Member_TeamDao;
import org.jichuang.hope6537.team.dao.TeamDao;
import org.jichuang.hope6537.team.dao.TeamTypeDao;
import org.jichuang.hope6537.team.model.Member_Team;
import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.team.model.TeamType;
import org.jichuang.hope6537.team.service.TeamService;
import org.jichuang.hope6537.utils.ApplicationConstant;
import org.jichuang.hope6537.utils.DateFormatCalculate;
import org.jichuang.hope6537.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("teamService")
public class TeamServiceImpl extends BaseServiceImpl<Team> implements
        TeamService {


    // 使用这种方式能够有效的环节AutoWired无法识别bean的问题
    @Autowired
    private TeamDao teamDao;

    @Autowired
    private TeamTypeDao teamTypeDao;

    @Autowired
    private Member_TeamDao member_teamDao;

    @Autowired
    private MemberDao memberDao;

    private boolean memberInTeam(Member member, Team team) {
        List<Member_Team> list = member_teamDao.selectEntryByHQL("from Member_Team where memberId = " + member.getMemberId() + " and teamId = " + team.getTeamId());
        return list != null && !list.isEmpty();
    }

    private boolean teamIsEditable4Member(Serializable teamId, Serializable memberId) {
        if (!(teamId != null && memberId != null)) {
            return false;
        }
        List<Team> teamListOfMember = dao.selectEntryBySQL("select t.* from Team t , Member_Team mt , Member m where m.memberId = mt.memberId and mt.teamId = t.teamId and t.teamId = " + teamId + " and m.memberId = " + memberId);
        if (teamListOfMember.isEmpty()) {
            return false;
        }
        return true;
    }


    @Override
    public List<Team> selectTeamListByMember(Member member) throws MemberException {
        return teamDao.selectTeamListByMember(member);
    }


    @Override
    public List<Team> selectTeamListByStatus(Status status) {
        return teamDao.selectTeamListByStatus(status);
    }

    @Override
    public List<Member_Team> selectMember_Team(Team team) {
        return member_teamDao.selectEntryByHQL("select mt from Member_Team mt, Member m  where mt.memberId = m.memberId and teamId = " + team.getTeamId());
    }

    @Override
    public List<Member> selectMemberOfTeam(Team team) {
        return memberDao.selectMemberListByTeam(team);
    }

    @Override
    public int insertTeam(Team team, Member member) {
        JSONObject info = new JSONObject();
        info.put("version", "0.1-SNAPSHOT");
        TeamType teamType = teamTypeDao.selectEntryFromPrimaryKey(team.getTeamTypeId().getTeamTypeId());
        team.setTeamTypeId(teamType);
        team.setDate(DateFormatCalculate.createNowTime());
        team.setStatus(Status.待审核.toString());
        team.setInfo(info.toJSONString());
        int res1 = this.insertEntry(team);
        Member_Team member_team = new Member_Team();
        member_team.setMemberId(member);
        member_team.setTeamId(team);
        member_team.setStatus("创建者");
        int res2 = member_teamDao.insertEntry(member_team);
        int res = res1 | res2;
        return res;
    }

    @Override
    public int deleteTeam(String teamId, Member member) {
        return teamDao.deleteTeam(teamId, member);
    }

    @Override
    public int updateTeam(Team team, Member member) {
        if (!teamIsEditable4Member(team.getTeamId(), member.getMemberId())) {
            return ApplicationConstant.EFFECTIVE_LINE_ZERO;
        }
        Team newTeam = this.selectEntryFromPrimaryKey(team.getTeamId());
        newTeam.setName(team.getName());
        newTeam.setDes(team.getDes());
        newTeam.setImage(team.getImage());
        return updateEntryByObject(newTeam);
    }

    @Override
    public boolean inviteMemberOfTeam(String memberId, String teamId, String status) {
        Member member = memberDao.selectEntryFromPrimaryKey(Integer.parseInt(memberId));
        Team team = teamDao.selectEntryFromPrimaryKey(Integer.parseInt(teamId));
        if (memberInTeam(member, team)) {
            return false;
        }
        Member_Team member_team = new Member_Team();
        member_team.setMemberId(member);
        member_team.setTeamId(team);
        member_team.setStatus(status);
        return member_teamDao.insertEntry(member_team) == ApplicationConstant.EFFECTIVE_LINE_ONE;
    }

    @Override
    public boolean updateInviteMemberOfTeam(String id, String status) {
        Member_Team member_team = member_teamDao.selectEntryFromPrimaryKey(Integer.parseInt(id));
      /*不会出现跨域修改
        if (member_team.getMemberId().getMemberId() != Integer.parseInt(memberId)) {
            member_team.setMemberId(memberDao.selectEntryFromPrimaryKey(Integer.parseInt(memberId)));
        }
        if (member_team.getTeamId().getTeamId() != Integer.parseInt(teamId)) {
            member_team.setTeamId(teamDao.selectEntryFromPrimaryKey(Integer.parseInt(teamId)));
        }*/
        member_team.setStatus(status);
        return member_teamDao.updateEntryByObject(member_team) == ApplicationConstant.EFFECTIVE_LINE_ONE;
    }

    @Override
    public boolean deleteInviteMemberOfTeam(String id, String status) {
        if (status.equals(ApplicationConstant.FOUNDER)) {
            return false;
        }
        return member_teamDao.deleteEntryByPrimaryKey(Integer.parseInt(id)) == ApplicationConstant.EFFECTIVE_LINE_ONE;
    }

}
