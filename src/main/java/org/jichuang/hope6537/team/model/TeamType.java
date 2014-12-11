package org.jichuang.hope6537.team.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 六.项目类型 TeamType —— 数据库表
 * 1.类型id ttid int 10
 * 2.类型名称 ttname varchar
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午7:35:40</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "teamtype")
public class TeamType implements Serializable {

    /**
     * <p>Describe: </p>
     * <p>Using: </p>
     */
    private static final long serialVersionUID = 1183669597803689947L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamTypeId")
    private Integer teamTypeId;
    @Column(name = "name")
    private String name;

    public Integer getTeamTypeId() {
        return teamTypeId;
    }

    public void setTeamTypeId(Integer teamTypeId) {
        this.teamTypeId = teamTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
