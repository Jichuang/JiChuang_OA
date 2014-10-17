package org.hope6537.model;

import java.util.Set;

/** 
 *<pre>
 *十二.私信对象 Message —— 数据库表/可能会使用XML进行映射
1.私信主键id mesid int 10
2.私信发信人 mesfrom_mid int 10 对应单一
3.私信收信人 改为多对多
4.私信标题 mestitle varchar 50
5.私信内容 mesdes varchar 500
6.私信时间 mesdate varchar 50
7.私信状态 messtatus varchar 50
8.私信其他信息：键值对 mesifno varchar 255
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:07:06</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Message {

	private Integer mesid;

	private String mestitle;

	private String mesdes;

	private String mesdate;

	private String messtatus;

	private String mesinfo;

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private Set<Member> memberFrom;

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private Set<Member> memberTo;

	public Set<Member> getMemberFrom() {
		return memberFrom;
	}

	public void setMemberFrom(Set<Member> memberFrom) {
		this.memberFrom = memberFrom;
	}

	public Set<Member> getMemberTo() {
		return memberTo;
	}

	public void setMemberTo(Set<Member> memberTo) {
		this.memberTo = memberTo;
	}

	public Integer getMesid() {
		return mesid;
	}

	public void setMesid(Integer mesid) {
		this.mesid = mesid;
	}

	public String getMestitle() {
		return mestitle;
	}

	public void setMestitle(String mestitle) {
		this.mestitle = mestitle;
	}

	public String getMesdes() {
		return mesdes;
	}

	public void setMesdes(String mesdes) {
		this.mesdes = mesdes;
	}

	public String getMesdate() {
		return mesdate;
	}

	public void setMesdate(String mesdate) {
		this.mesdate = mesdate;
	}

	public String getMesstatus() {
		return messtatus;
	}

	public void setMesstatus(String messtatus) {
		this.messtatus = messtatus;
	}

	public String getMesinfo() {
		return mesinfo;
	}

	public void setMesinfo(String mesinfo) {
		this.mesinfo = mesinfo;
	}

	@Override
	public String toString() {
		return "Message [mesid=" + mesid + ", mestitle=" + mestitle
				+ ", mesdes=" + mesdes + ", mesdate=" + mesdate
				+ ", messtatus=" + messtatus + ", mesinfo=" + mesinfo + "]";
	}

	public Message(Integer mesid, String mestitle, String mesdes,
			String mesdate, String messtatus, String mesinfo) {
		super();
		this.mesid = mesid;
		this.mestitle = mestitle;
		this.mesdes = mesdes;
		this.mesdate = mesdate;
		this.messtatus = messtatus;
		this.mesinfo = mesinfo;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}
}
