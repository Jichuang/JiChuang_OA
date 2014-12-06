package org.hope6537.team.test;

import org.jichuang.hope6537.team.model.Team;
import org.jichuang.hope6537.team.model.TeamType;
import org.jichuang.hope6537.team.service.TeamService;
import org.jichuang.hope6537.utils.SpringHelper;
import org.junit.Test;

/**
 * Created by Zhaopeng-Rabook on 14-12-6.
 */
public class TeamServiceTest extends SpringHelper {

    public TeamServiceTest() {
        super(true);
    }

    public Team appendTeam() {

        Team team = new Team("test", "test", "test", "test", "test");
        TeamType teamType = new TeamType();
        teamType.setName("testType");
        team.setTeamTypeId(teamType);
        return team;
    }

    @Test
    public void testAddTeam() {

        TeamService teamService = (TeamService) context.getBean("teamService");
        int res = teamService.insertEntry(appendTeam());
        System.out.println(res);
    }
}
