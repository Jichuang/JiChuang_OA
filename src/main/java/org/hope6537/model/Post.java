package org.hope6537.model;

import java.io.Serializable;
import java.util.Set;

/** 
 *<pre>
 *三.职务对象 Post —— 数据库表
 *1.职务主键 pid int 10 自增长
 *2.职务描述 pdes varchar 255 自增长
 *3.职务状态 pstatus varchar 255 自增长
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:38:42</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Post implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 2909208994893032227L;

	private Integer pid;

	private String pdes;

	private String pstatus;

	private Set<Member> members;

	private Set<Role> roles;

	public Post(Integer pid, String pdes, String pstatus) {
		super();
		this.pid = pid;
		this.pdes = pdes;
		this.pstatus = pstatus;
	}

	@Override
	public String toString() {
		return "Post [pid=" + pid + ", pdes=" + pdes + ", pstatus=" + pstatus
				+ "]";
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPdes() {
		return pdes;
	}

	public void setPdes(String pdes) {
		this.pdes = pdes;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
