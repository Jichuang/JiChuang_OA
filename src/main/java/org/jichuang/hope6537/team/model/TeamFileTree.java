package org.jichuang.hope6537.team.model;

import java.io.Serializable;

public class TeamFileTree implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 5811179989741569326L;

	private Integer tfid;

	private Team tftid;

	private String tfpath;

	private String tfstatus;

	public Integer getTfid() {
		return tfid;
	}

	public void setTfid(Integer tfid) {
		this.tfid = tfid;
	}

	public Team getTftid() {
		return tftid;
	}

	public void setTftid(Team tftid) {
		this.tftid = tftid;
	}

	public String getTfpath() {
		return tfpath;
	}

	public void setTfpath(String tfpath) {
		this.tfpath = tfpath;
	}

	public String getTfstatus() {
		return tfstatus;
	}

	public void setTfstatus(String tfstatus) {
		this.tfstatus = tfstatus;
	}

	public TeamFileTree() {
	}

	@Override
	public String toString() {
		return "TeamFileTree [tfid=" + tfid + ", tftid=" + tftid + ", tfpath="
				+ tfpath + ", tfstatus=" + tfstatus + "]";
	}

	public TeamFileTree(Integer tfid, Team tftid, String tfpath, String tfstatus) {
		super();
		this.tfid = tfid;
		this.tftid = tftid;
		this.tfpath = tfpath;
		this.tfstatus = tfstatus;
	}

}
