package org.hope6537.model;

import java.io.Serializable;

/** 
 *<pre>
 *十五.代码版本对象 Version —— 数据库表
 *1.版本主键 vid int 10
 *2.版本父版本 vbefore int 10
 *3.版本配置文件xml路径 vpath varchar 255
 *4.版本更新日期 vdate varchar 255
 *5.版本更新人 vmid int 10
 *6.版本所属团队 vtid int 10
 *7.版本其他信息 vinfo varchar 255
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:14:14</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Version implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -1706315573248701706L;

	private Integer vid;

	private Version vbefore;

	private String vpath;

	private String vdate;

	private Member vmid;

	private Team vtid;

	private String vinfo;

	private String vstatus;

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Version getVbefore() {
		return vbefore;
	}

	public void setVbefore(Version vbefore) {
		this.vbefore = vbefore;
	}

	public String getVpath() {
		return vpath;
	}

	public void setVpath(String vpath) {
		this.vpath = vpath;
	}

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	public Member getVmid() {
		return vmid;
	}

	public void setVmid(Member vmid) {
		this.vmid = vmid;
	}

	public Team getVtid() {
		return vtid;
	}

	public void setVtid(Team vtid) {
		this.vtid = vtid;
	}

	public String getVinfo() {
		return vinfo;
	}

	public void setVinfo(String vinfo) {
		this.vinfo = vinfo;
	}

	@Override
	public String toString() {
		return "Version [vid=" + vid + ", vbefore=" + vbefore + ", vpath="
				+ vpath + ", vdate=" + vdate + ", vmid=" + vmid + ", vtid="
				+ vtid + ", vinfo=" + vinfo + "]";
	}

	public Version(Integer vid, Version vbefore, String vpath, String vdate,
			Member vmid, Team vtid, String vinfo) {
		super();
		this.vid = vid;
		this.vbefore = vbefore;
		this.vpath = vpath;
		this.vdate = vdate;
		this.vmid = vmid;
		this.vtid = vtid;
		this.vinfo = vinfo;
	}

	public Version() {

	}

	public String getVstatus() {
		return vstatus;
	}

	public void setVstatus(String vstatus) {
		this.vstatus = vstatus;
	}

}
