package org.jichuang.hope6537.base.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 二.权限对象 Role —— 数据库表
 * 1.权限主键 rid int 10 自增长
 * 2.权限陈述 rdes varchar 255
 * 3.权限状态 rstatus varchar 50
 * 4.父权限 rrid int 10;
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:35:49</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "Role")
public class Role implements Serializable {

    private static final long serialVersionUID = -4637884703425668945L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId", length = 50)
    private Integer roleId;
    @Column(name = "des", length = 50)
    private String des;
    @Column(name = "status", length = 50)
    private String status;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
}
