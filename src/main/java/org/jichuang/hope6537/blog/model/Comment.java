package org.jichuang.hope6537.blog.model;

import org.jichuang.hope6537.base.model.Member;

import javax.persistence.*;

/**
 * 博客评论对象
 * 博客和评论关系为一对多
 * 用户和评论关系一对多
 *
 * @author Hope6537
 */
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentId", length = 50)
    private Integer commentId;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "content", length = 5000)
    private String content;
    @Column(name = "date", length = 100)
    private String date;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "memberId")
    private Member memberId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Blog.class)
    @JoinColumn(name = "blogId")
    private Blog blogId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Comment.class)
    @JoinColumn(name = "parentId")
    private Comment parentId;
    @Column(name = "status", length = 50)
    private String status;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public Blog getBlogId() {
        return blogId;
    }

    public void setBlogId(Blog blogId) {
        this.blogId = blogId;
    }

    public Comment getParentId() {
        return parentId;
    }

    public void setParentId(Comment parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
