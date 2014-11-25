package org.jichuang.hope6537.notification.model;

import java.io.Serializable;
import java.util.Set;

import org.jichuang.hope6537.base.model.Member;

/** 
 *<pre>
 *九.通知对象 Notification  —— 数据库表
1、通知id nid int 10
2、通知内容 ninfo varchar 10
3、通知时间 ndate varchar 255
4、通知发起人 nmid int 10
5、通知其他信息：键值对 ninfo varchar 255
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午7:48:12</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Notification implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -1014917383769235149L;

	private Integer nid;

	private String ndes;

	private String ndate;

	private Set<Member> nmid;

	private String ninfo;

	public Notification() {
	}

	@Override
	public String toString() {
		return "Notification [nid=" + nid + ", ndes=" + ndes + ", ndate="
				+ ndate + ", nmid=" + nmid + ", ninfo=" + ninfo + "]";
	}

	public Notification(Integer nid, String ndes, String ndate,
			Set<Member> nmid, String ninfo) {
		super();
		this.nid = nid;
		this.ndes = ndes;
		this.ndate = ndate;
		this.nmid = nmid;
		this.ninfo = ninfo;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getNdes() {
		return ndes;
	}

	public void setNdes(String ndes) {
		this.ndes = ndes;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	public Set<Member> getNmid() {
		return nmid;
	}

	public void setNmid(Set<Member> nmid) {
		this.nmid = nmid;
	}

	public String getNinfo() {
		return ninfo;
	}

	public void setNinfo(String ninfo) {
		this.ninfo = ninfo;
	}

}