package org.jichuang.hope6537.notification.model;

import org.jichuang.hope6537.base.model.Member;

import javax.persistence.*;

@Entity
@Table(name = "Member_Notification")
public class Member_Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 50)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "memberId")
    private Member memberId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Notification.class)
    @JoinColumn(name = "notificationId")
    private Member notificationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public Member getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Member notificationId) {
        this.notificationId = notificationId;
    }
}
