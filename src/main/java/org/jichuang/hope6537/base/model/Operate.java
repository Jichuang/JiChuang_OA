package org.jichuang.hope6537.base.model;

import java.io.Serializable;
import java.util.Set;

/** 
 * <p>Describe: 操作过滤器对象</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月19日下午7:26:10</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Operate implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 6266470652037079734L;

	private Integer operateId;

	private String des;

	private String info;

	private String status;

	private Set<Role> roles;

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
