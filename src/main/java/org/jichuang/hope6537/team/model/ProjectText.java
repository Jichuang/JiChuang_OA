package org.jichuang.hope6537.team.model;

import org.jichuang.hope6537.base.model.Member;

import java.io.Serializable;

/**
 * <pre>
 * 十六.项目笔记对象 ProjectText —— 数据库表
 * 1.项目笔记主键 ptid int 10
 * 2.项目笔记撰写人 ptmid int 10
 * 3.笔记对应项目 pttid int 10
 * 4.项目笔记标题 pttitle varchar 255
 * 5.项目笔记内容 ptcont varchar 255
 * 6.项目笔记状态 ptstatus varchar 255
 * 7.项目笔记其他内容 ptinfo varchar 255
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:19:02</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class ProjectText implements Serializable {

    /**
     * <p>Describe: </p>
     * <p>Using: </p>
     */
    private static final long serialVersionUID = -59933759423405196L;
    private Integer ptid;
    private Member ptmid;
    private Team pttid;
    private String pttitle;
    private String ptcont;
    private String ptstatus;
    private String ptinfo;

    public ProjectText() {

    }

    public ProjectText(Integer ptid, Member ptmid, Team pttid, String pttitle,
                       String ptcont, String ptstatus, String ptinfo) {
        super();
        this.ptid = ptid;
        this.ptmid = ptmid;
        this.pttid = pttid;
        this.pttitle = pttitle;
        this.ptcont = ptcont;
        this.ptstatus = ptstatus;
        this.ptinfo = ptinfo;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public Member getPtmid() {
        return ptmid;
    }

    public void setPtmid(Member ptmid) {
        this.ptmid = ptmid;
    }

    public Team getPttid() {
        return pttid;
    }

    public void setPttid(Team pttid) {
        this.pttid = pttid;
    }

    public String getPttitle() {
        return pttitle;
    }

    public void setPttitle(String pttitle) {
        this.pttitle = pttitle;
    }

    public String getPtcont() {
        return ptcont;
    }

    public void setPtcont(String ptcont) {
        this.ptcont = ptcont;
    }

    public String getPtstatus() {
        return ptstatus;
    }

    public void setPtstatus(String ptstatus) {
        this.ptstatus = ptstatus;
    }

    public String getPtinfo() {
        return ptinfo;
    }

    public void setPtinfo(String ptinfo) {
        this.ptinfo = ptinfo;
    }

    @Override
    public String toString() {
        return "ProjectText [ptid=" + ptid + ", ptmid=" + ptmid + ", pttid="
                + pttid + ", pttitle=" + pttitle + ", ptcont=" + ptcont
                + ", ptstatus=" + ptstatus + ", ptinfo=" + ptinfo + "]";
    }


}
