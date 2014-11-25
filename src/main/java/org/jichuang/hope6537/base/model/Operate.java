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

	private Integer oid;

	private String odes;

	private String oinfo;

	private String ostatus;

	private Set<Role> oroles;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOdes() {
		return odes;
	}

	public void setOdes(String odes) {
		this.odes = odes;
	}

	public String getOinfo() {
		return oinfo;
	}

	public void setOinfo(String oinfo) {
		this.oinfo = oinfo;
	}

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public Set<Role> getOroles() {
		return oroles;
	}

	public void setOroles(Set<Role> oroles) {
		this.oroles = oroles;
	}

	public Operate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Operate [oid=" + oid + ", odes=" + odes + ", oinfo=" + oinfo
				+ ", ostatus=" + ostatus + ", oroles=" + oroles + "]";
	}

	public Operate(String odes, String oinfo, String ostatus, Set<Role> oroles) {
		super();
		this.odes = odes;
		this.oinfo = oinfo;
		this.ostatus = ostatus;
		this.oroles = oroles;
	}

}
