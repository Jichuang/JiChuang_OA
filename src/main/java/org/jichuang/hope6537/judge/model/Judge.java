package org.jichuang.hope6537.judge.model;

import java.io.Serializable;

import org.jichuang.hope6537.base.model.Member;

/** 
 *<pre>
 *四.审批对象 Judge —— 数据库表
 *1.审批主键 jid int 10 自增长
 *2.审批内容 jdes varchar 1000 可能会动用I/O存储
 *3.审批来源（发送人员）（团队成员主键） jfrom_mid int 10 仅单一
 *4.审批目的地（审批人员）（团队成员主键） jto_mid int 10 仅单一
 *5.审批状态 jstatus varchar 50
 *6.审批发送日期 jstartdate varchar 100
 *7.审批确认日期 jstartdate varchar 100
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:40:19</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Judge implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 4724189934148685776L;

	private Integer jid;

	private String jdes;

	private Member jfrom;

	private Member jto;

	private String jstatus;

	private String jstartdate;

	private String jenddate;

	private String jinfo;

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public String getJdes() {
		return jdes;
	}

	public void setJdes(String jdes) {
		this.jdes = jdes;
	}

	public Member getJfrom() {
		return jfrom;
	}

	public void setJfrom(Member jfrom) {
		this.jfrom = jfrom;
	}

	public Member getJto() {
		return jto;
	}

	public void setJto(Member jto) {
		this.jto = jto;
	}

	public String getJstatus() {
		return jstatus;
	}

	public void setJstatus(String jstatus) {
		this.jstatus = jstatus;
	}

	public String getJstartdate() {
		return jstartdate;
	}

	public void setJstartdate(String jstartdate) {
		this.jstartdate = jstartdate;
	}

	public String getJenddate() {
		return jenddate;
	}

	public void setJenddate(String jenddate) {
		this.jenddate = jenddate;
	}

	public Judge(Integer jid, String jdes, Member jfrom, Member jto,
			String jstatus, String jstartdate, String jenddate) {
		super();
		this.jid = jid;
		this.jdes = jdes;
		this.jfrom = jfrom;
		this.jto = jto;
		this.jstatus = jstatus;
		this.jstartdate = jstartdate;
		this.jenddate = jenddate;
	}

	public Judge(String jdes, Member jfrom, Member jto, String jstatus,
			String jstartdate, String jenddate) {
		super();
		this.jdes = jdes;
		this.jfrom = jfrom;
		this.jto = jto;
		this.jstatus = jstatus;
		this.jstartdate = jstartdate;
		this.jenddate = jenddate;
	}

	public Judge() {
	}

	@Override
	public String toString() {
		return "Judge [jid=" + jid + ", jdes=" + jdes + ", jfrom=" + jfrom
				+ ", jto=" + jto + ", jstatus=" + jstatus + ", jstartdate="
				+ jstartdate + ", jenddate=" + jenddate + "]";
	}

	public String getJinfo() {
		return jinfo;
	}

	public void setJinfo(String jinfo) {
		this.jinfo = jinfo;
	}

}
