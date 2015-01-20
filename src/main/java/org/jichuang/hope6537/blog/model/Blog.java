package org.jichuang.hope6537.blog.model;

import org.jichuang.hope6537.base.model.Member;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 1.博客主键id blogid int 10
 * 2.博客作者 blogmid varchar 255
 * 3.博客标题 blogtitle varchar 255
 * 4.博客内容 blogcont varchar 255
 * 5.博客发布时间 blogdate varchar 255
 * 6.博客状态 blogstatus varchar 255
 * 7.博客其他信息 bloginfo varchar 255
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:11:11</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "Blog")
public class Blog implements Serializable {

    /**
     * <p>Describe: </p>
     * <p>Using: </p>
     */
    private static final long serialVersionUID = -3801905772606042564L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blogId", length = 50)
    private Integer blogId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Member.class)
    @JoinColumn(name = "memberId")
    private Member memberId;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "content", length = 5000)
    private String content;
    @Column(name = "date", length = 50)
    private String date;
    @Column(name = "status", length = 50)
    private String status;
    @Column(name = "info", length = 50)
    private String info;
    public Blog() {

    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", memberId=" + memberId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
