package org.jichuang.hope6537.team.model;

import org.jichuang.hope6537.base.model.Member;

import javax.persistence.*;

/**
 * Created by Zhaopeng-Rabook on 14-12-7.
 */

@Entity
@Table(name = "Member_Team")
public class Member_Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 50)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "memberId")
    private Member memberId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Team.class)
    @JoinColumn(name = "teamId")
    private Team teamId;

    @Column(name = "status", length = 50)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }
}
