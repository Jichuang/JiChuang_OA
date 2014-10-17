package org.hope6537.model;

import java.io.Serializable;
import java.util.Set;

/** 
 * <pre>
 *五.项目组对象 Team —— 数据库表
*1.项目组主键 tid int 10 自增长
*2.项目组标题 tname varchar 100
*3.项目组封面图片 timage varchar 255
*4.项目组内容 tdes varchar 255
*5.项目组最新版本树 tvid int 10（使用了版本对象---他会一直回溯）
*6.关于项目组人员管理使用多对多模型
*7.项目组其他信息 tqa varchar 1000 键值对模型
*8.项目组创建日期 tdate varchar 255
*9.项目组其他信息：键值对 tinfo varchar 255
*10.项目组类型信息 ttid int 10
*</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:43:36</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Team implements Serializable {
	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -7944792669434983778L;

	private Integer tid;

	private String tname;

	private String timage;

	private String tdes;

	private String tqa;

	private String tdate;

	private String tinfo;

	private TeamType ttid;

	private Set<Member> members;

	public Team(Integer tid, String tname, String timage, String tdes,
			String tqa, String tdate, String tinfo, TeamType ttid) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.timage = timage;
		this.tdes = tdes;
		this.tqa = tqa;
		this.tdate = tdate;
		this.tinfo = tinfo;
		this.ttid = ttid;
	}

	public Team(String tname, String timage, String tdes, String tqa,
			String tdate, String tinfo, TeamType ttid) {
		super();
		this.tname = tname;
		this.timage = timage;
		this.tdes = tdes;
		this.tqa = tqa;
		this.tdate = tdate;
		this.tinfo = tinfo;
		this.ttid = ttid;
	}

	public Team() {

	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTimage() {
		return timage;
	}

	public void setTimage(String timage) {
		this.timage = timage;
	}

	public String getTdes() {
		return tdes;
	}

	public void setTdes(String tdes) {
		this.tdes = tdes;
	}

	public String getTqa() {
		return tqa;
	}

	public void setTqa(String tqa) {
		this.tqa = tqa;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public String getTinfo() {
		return tinfo;
	}

	public void setTinfo(String tinfo) {
		this.tinfo = tinfo;
	}

	public TeamType getTtid() {
		return ttid;
	}

	public void setTtid(TeamType ttid) {
		this.ttid = ttid;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

}
