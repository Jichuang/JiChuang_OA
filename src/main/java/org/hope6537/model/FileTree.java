package org.hope6537.model;

import java.io.Serializable;


/** 
 *<pre>
 *七.个人文件树对象 —— 数据库表，每条数据都有一个父文件的外键 / 也可能使用XML进行映射 单单只在数据库中记录XML的地址
 *1.文件树对象主键 fid int 10 自增长
 *2.文件树用户外键 fmid int 10 一对一
 *3.文件树xml路径地址 fpath varchar 255 
 *4.文件树状态 fstatus varchar 50
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午7:39:45</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class FileTree implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 466294696456934278L;

	private Integer fid;

	private Member fmid;

	private String fpath;

	private String fstatus;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Member getFmid() {
		return fmid;
	}

	public void setFmid(Member fmid) {
		this.fmid = fmid;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public String getFstatus() {
		return fstatus;
	}

	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}

}
