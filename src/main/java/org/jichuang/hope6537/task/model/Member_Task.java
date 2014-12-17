package org.jichuang.hope6537.task.model;

import org.jichuang.hope6537.base.model.Member;

import javax.persistence.*;

/**
 * Created by Zhaopeng-Rabook on 14-12-17.
 */
@Entity
@Table(name = "Member_Task")
public class Member_Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "sentMemberId")
    private Member sentMemberId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "getMemberId")
    private Member getMemberId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Task.class)
    @JoinColumn(name = "taskId")
    private Task taskId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getSentMemberId() {
        return sentMemberId;
    }

    public void setSentMemberId(Member sentMemberId) {
        this.sentMemberId = sentMemberId;
    }

    public Member getGetMemberId() {
        return getMemberId;
    }

    public void setGetMemberId(Member getMemberId) {
        this.getMemberId = getMemberId;
    }

    public Task getTaskId() {
        return taskId;
    }

    public void setTaskId(Task taskId) {
        this.taskId = taskId;
    }
}
