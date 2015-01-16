package org.jichuang.hope6537.base.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 三.职务对象 Post —— 数据库表
 * 1.职务主键 pid int 10 自增长
 * 2.职务描述 pdes varchar 255 自增长
 * 3.职务状态 pstatus varchar 255 自增长
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:38:42</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "Post")
public class Post implements Serializable {

    private static final long serialVersionUID = 2909208994893032227L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId", length = 50)
    private Integer postId;
    @Column(name = "des", length = 50)
    private String des;
    @Column(name = "status", length = 50)
    private String status;

    @Transient
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", des='" + des + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
