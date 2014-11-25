package org.jichuang.hope6537.team.model;

import java.io.Serializable;

/** 
 *<pre>
 *六.项目类型 TeamType —— 数据库表
 *1.类型id ttid int 10
 *2.类型名称 ttname varchar 
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午7:35:40</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class TeamType implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 1183669597803689947L;

	private Integer ttid;

	private String ttname;

	public TeamType(Integer ttid, String ttname) {
		super();
		this.ttid = ttid;
		this.ttname = ttname;
	}

	public Integer getTtid() {
		return ttid;
	}

	public void setTtid(Integer ttid) {
		this.ttid = ttid;
	}

	public String getTtname() {
		return ttname;
	}

	public void setTtname(String ttname) {
		this.ttname = ttname;
	}

	public TeamType() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TeamType [ttid=" + ttid + ", ttname=" + ttname + "]";
	}

}
