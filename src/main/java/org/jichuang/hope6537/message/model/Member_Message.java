package org.jichuang.hope6537.message.model;

import org.jichuang.hope6537.base.model.Member;

import javax.persistence.*;

@Entity
@Table(name = "Member_Message")
public class Member_Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 50)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "sentMemberId")
    private Member sentMemberId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "getMemberId")
    private Member getMemberId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Message.class)
    @JoinColumn(name = "messageId")
    private Member messageId;

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

    public Member getMessageId() {
        return messageId;
    }

    public void setMessageId(Member messageId) {
        this.messageId = messageId;
    }
}
