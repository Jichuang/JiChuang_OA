package org.jichuang.hope6537.cale;

import java.io.Serializable;

import org.jichuang.hope6537.team.model.Team;

public class Cale implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -8397832384066686723L;

	public Cale() {

	}

	private Integer caleId;

	private String date;

	private Team teamId;

	private String status;

	private String info;

	public Integer getCaleId() {
		return caleId;
	}

	public void setCaleId(Integer caleId) {
		this.caleId = caleId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Team getTeamId() {
		return teamId;
	}

	public void setTeamId(Team teamId) {
		this.teamId = teamId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
