package org.hope6537.model;

import java.io.Serializable;
import java.util.Set;

/** 
 *<pre>
 *二.权限对象 Role —— 数据库表
 *1.权限主键 rid int 10 自增长
 *2.权限陈述 rdes varchar 255 
 *3.权限状态 rstatus varchar 50 
 *4.父权限 rrid int 10;
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:35:49</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -4637884703425668945L;

	private Integer rid;

	private String rdes;

	private String rstatus;

	private Role rrid;

	private Set<Post> posts;

	private Set<Operate> operates;

	public Set<Operate> getOperates() {
		return operates;
	}

	public void setOperates(Set<Operate> operates) {
		this.operates = operates;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRdes() {
		return rdes;
	}

	public void setRdes(String rdes) {
		this.rdes = rdes;
	}

	public String getRstatus() {
		return rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public Role getRrid() {
		return rrid;
	}

	public void setRrid(Role rrid) {
		this.rrid = rrid;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
