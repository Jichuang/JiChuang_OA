package org.jichuang.hope6537.judge.model;

import java.io.Serializable;

import org.jichuang.hope6537.base.model.Member;

public class Buy implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -2709301345631812899L;

	private Integer bid;

	private String bdes;

	private String bstatus;

	private String bdate;

	private Member breg;

	private Member bsub;

	private Integer bcash;

	private String binfo;

	public Buy(Integer bid, String bdes, String bstatus, String bdate,
			Member breg, Member bsub, Integer bcash, String binfo) {
		super();
		this.bid = bid;
		this.bdes = bdes;
		this.bstatus = bstatus;
		this.bdate = bdate;
		this.breg = breg;
		this.bsub = bsub;
		this.bcash = bcash;
		this.binfo = binfo;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBdes() {
		return bdes;
	}

	public void setBdes(String bdes) {
		this.bdes = bdes;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public Member getBreg() {
		return breg;
	}

	public void setBreg(Member breg) {
		this.breg = breg;
	}

	public Member getBsub() {
		return bsub;
	}

	public void setBsub(Member bsub) {
		this.bsub = bsub;
	}

	public Integer getBcash() {
		return bcash;
	}

	public void setBcash(Integer bcash) {
		this.bcash = bcash;
	}

	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}

	@Override
	public String toString() {
		return "Buy [bid=" + bid + ", bdes=" + bdes + ", bstatus=" + bstatus
				+ ", bdate=" + bdate + ", breg=" + breg + ", bsub=" + bsub
				+ ", bcash=" + bcash + ", binfo=" + binfo + "]";
	}

}
