package org.jichuang.hope6537.news.model;

import org.jichuang.hope6537.base.model.Member;

/**
 * <pre>
 * 十一.新闻对象 News —— 数据库表
 * 1.新闻主键id newsid int 10
 * 2.新闻描述 newsdes varchar 255
 * 3.新闻事件 newsdate varchar 50
 * 4.新闻状态 newsstatus varchar 50
 * 5.新闻撰写人 newsmid int 10
 * 6.新闻其他信息：键值对 newsinfo varchar 255
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:07:14</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class News {

    private Integer newsid;

    private String newsdes;

    private String newsdate;

    private String newsstatus;

    private Member newsmid;

    private String newsinfo;

    private String newstitle;

    public News(Integer newsid, String newsdes, String newsdate,
                String newsstatus, Member newsmid, String newsinfo) {
        super();
        this.newsid = newsid;
        this.newsdes = newsdes;
        this.newsdate = newsdate;
        this.newsstatus = newsstatus;
        this.newsmid = newsmid;
        this.newsinfo = newsinfo;
    }

    public News() {

    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewsdes() {
        return newsdes;
    }

    public void setNewsdes(String newsdes) {
        this.newsdes = newsdes;
    }

    public String getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(String newsdate) {
        this.newsdate = newsdate;
    }

    public String getNewsstatus() {
        return newsstatus;
    }

    public void setNewsstatus(String newsstatus) {
        this.newsstatus = newsstatus;
    }

    public Member getNewsmid() {
        return newsmid;
    }

    public void setNewsmid(Member newsmid) {
        this.newsmid = newsmid;
    }

    public String getNewsinfo() {
        return newsinfo;
    }

    public void setNewsinfo(String newsinfo) {
        this.newsinfo = newsinfo;
    }

    @Override
    public String toString() {
        return "News [newsid=" + newsid + ", newsdes=" + newsdes
                + ", newsdate=" + newsdate + ", newsstatus=" + newsstatus
                + ", newsmid=" + newsmid.toString() + ", newsinfo=" + newsinfo
                + "]";
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

}
