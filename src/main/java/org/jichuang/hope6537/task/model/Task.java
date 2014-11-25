package org.jichuang.hope6537.task.model;

import java.io.Serializable;
import java.util.Set;

import org.jichuang.hope6537.base.model.Member;

/** 
 *<pre>
 *十三.任务对象 Task —— 数据库表
1.任务主键id taskid int 10
2.任务发起人 taskfrom_mid int 10 一个
（源任务接收人被改为多对多）
3.任务描述 taskdes varchar 255
4.任务发起时间 taskstart varchar 255
5.任务截止期限 taskdead varchar 255
6.任务结束时间 taskend varchar 255
7.任务状态 taskstatus varchar 50
8.任务其他信息 taskinfo varchar 255
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:07:23</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Task implements Serializable {

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 1884133633273726805L;

	private Integer taskid;

	private String taskdes;

	private String taskstart;

	private String taskdead;

	private String taskend;

	private String taskstatus;

	private String taskinfo;

	private Set<Member> memberFrom;

	private Set<Member> memberTo;

	public Set<Member> getMemberFrom() {
		return memberFrom;
	}

	public void setMemberFrom(Set<Member> memberFrom) {
		this.memberFrom = memberFrom;
	}

	public Set<Member> getMemberTo() {
		return memberTo;
	}

	public void setMemberTo(Set<Member> memberTo) {
		this.memberTo = memberTo;
	}

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getTaskdes() {
		return taskdes;
	}

	public void setTaskdes(String taskdes) {
		this.taskdes = taskdes;
	}

	public String getTaskstart() {
		return taskstart;
	}

	public void setTaskstart(String taskstart) {
		this.taskstart = taskstart;
	}

	public String getTaskdead() {
		return taskdead;
	}

	public void setTaskdead(String taskdead) {
		this.taskdead = taskdead;
	}

	public String getTaskend() {
		return taskend;
	}

	public void setTaskend(String taskend) {
		this.taskend = taskend;
	}

	public String getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}

	public String getTaskinfo() {
		return taskinfo;
	}

	public void setTaskinfo(String taskinfo) {
		this.taskinfo = taskinfo;
	}

	public Task(Integer taskid, String taskdes, String taskstart,
			String taskdead, String taskend, String taskstatus, String taskinfo) {
		super();
		this.taskid = taskid;
		this.taskdes = taskdes;
		this.taskstart = taskstart;
		this.taskdead = taskdead;
		this.taskend = taskend;
		this.taskstatus = taskstatus;
		this.taskinfo = taskinfo;
	}

}
