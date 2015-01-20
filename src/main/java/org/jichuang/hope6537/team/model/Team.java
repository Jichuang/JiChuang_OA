package org.jichuang.hope6537.team.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 五.项目组对象 Team —— 数据库表
 * 1.项目组主键 tid int 10 自增长
 * 2.项目组标题 tname varchar 100
 * 3.项目组封面图片 timage varchar 255
 * 4.项目组内容 tdes varchar 255
 * 5.项目组最新版本树 tvid int 10（使用了版本对象---他会一直回溯）
 * 6.关于项目组人员管理使用多对多模型
 * 7.项目组其他信息 tqa varchar 1000 键值对模型
 * 8.项目组创建日期 tdate varchar 255
 * 9.项目组其他信息：键值对 tinfo varchar 255
 * 10.项目组类型信息 ttid int 10
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:43:36</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "team")
public class Team implements Serializable {
    /**
     * <p>Describe: </p>
     * <p>Using: </p>
     */
    private static final long serialVersionUID = -7944792669434983778L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamId")
    private Integer teamId;
    @Column(name = "name")
    private String name;
    @Column(name = "image", length = 1000)
    private String image;
    @Column(name = "des", length = 1000)
    private String des;
    @Column(name = "status", length = 50)
    private String status;
    @Column(name = "date")
    private String date;
    @Column(name = "info", length = 1000)
    private String info;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = TeamType.class)
    @JoinColumn(name = "teamTypeId")
    private TeamType teamTypeId;

    public Team() {
    }

    public Team(String name, String image, String des, String date, String info) {
        this.name = name;
        this.image = image;
        this.des = des;
        this.date = date;
        this.info = info;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public TeamType getTeamTypeId() {
        return teamTypeId;
    }

    public void setTeamTypeId(TeamType teamTypeId) {
        this.teamTypeId = teamTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", des='" + des + '\'' +
                ", date='" + date + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
