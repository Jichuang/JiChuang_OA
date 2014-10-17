package org.hope6537.model;

import java.io.Serializable;

/** 
 *<pre>
 *1.博客主键id blogid int 10
 *2.博客作者 blogmid varchar 255
 *3.博客标题 blogtitle varchar 255
 *4.博客内容 blogcont varchar 255
 *5.博客发布时间 blogdate varchar 255
 *6.博客状态 blogstatus varchar 255
 *7.博客其他信息 bloginfo varchar 255
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:11:11</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Blog implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = -3801905772606042564L;

	public Blog() {

	}

	private Integer blogid;

	private Member blogmid;

	private String blogtitle;

	private String blogcont;

	private String blogdate;

	private String blogstatus;

	private String bloginfo;

	public Integer getBlogid() {
		return blogid;
	}

	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}

	public Member getBlogmid() {
		return blogmid;
	}

	public void setBlogmid(Member blogmid) {
		this.blogmid = blogmid;
	}

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getBlogcont() {
		return blogcont;
	}

	public void setBlogcont(String blogcont) {
		this.blogcont = blogcont;
	}

	public String getBlogdate() {
		return blogdate;
	}

	public void setBlogdate(String blogdate) {
		this.blogdate = blogdate;
	}

	public String getBlogstatus() {
		return blogstatus;
	}

	public void setBlogstatus(String blogstatus) {
		this.blogstatus = blogstatus;
	}

	public String getBloginfo() {
		return bloginfo;
	}

	public void setBloginfo(String bloginfo) {
		this.bloginfo = bloginfo;
	}

	public Blog(Integer blogid, Member blogmid, String blogtitle,
			String blogcont, String blogdate, String blogstatus, String bloginfo) {
		super();
		this.blogid = blogid;
		this.blogmid = blogmid;
		this.blogtitle = blogtitle;
		this.blogcont = blogcont;
		this.blogdate = blogdate;
		this.blogstatus = blogstatus;
		this.bloginfo = bloginfo;
	}

	@Override
	public String toString() {
		return "Blog [blogid=" + blogid + ", blogmid=" + blogmid.toString()
				+ ", blogtitle=" + blogtitle + ", blogcont=" + blogcont
				+ ", blogdate=" + blogdate + ", blogstatus=" + blogstatus
				+ ", bloginfo=" + bloginfo + "]";
	}

}
