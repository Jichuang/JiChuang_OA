package org.hope6537.model;

import java.io.Serializable;

public class Cale implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -8397832384066686723L;

	public Cale() {

	}

	private Integer caid;

	private String cadate;

	private Team catid;

	private String catstatus;

	private String cainfo;

	@Override
	public String toString() {
		return "Cale [caid=" + caid + ", cadate=" + cadate + ", catid=" + catid
				+ ", catstatus=" + catstatus + ", cainfo=" + cainfo + "]";
	}

	public Integer getCaid() {
		return caid;
	}

	public void setCaid(Integer caid) {
		this.caid = caid;
	}

	public String getCadate() {
		return cadate;
	}

	public void setCadate(String cadate) {
		this.cadate = cadate;
	}

	public Team getCatid() {
		return catid;
	}

	public void setCatid(Team catid) {
		this.catid = catid;
	}

	public String getCatstatus() {
		return catstatus;
	}

	public void setCatstatus(String catstatus) {
		this.catstatus = catstatus;
	}

	public String getCainfo() {
		return cainfo;
	}

	public void setCainfo(String cainfo) {
		this.cainfo = cainfo;
	}

	public Cale(Integer caid, String cadate, Team catid, String catstatus,
			String cainfo) {
		super();
		this.caid = caid;
		this.cadate = cadate;
		this.catid = catid;
		this.catstatus = catstatus;
		this.cainfo = cainfo;
	}

}
