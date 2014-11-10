package org.hope6537.model;

import java.io.Serializable;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hope6537.utils.AESLocker;

/** 
 * <pre>
 * 一.团队成员对象 Member —— 数据库表 基本字段如下
 * 1.团队成员主键 mid int 10自增长
 * 2.团队成员用户名 musername varchar 60 可能自定义，可能使用（公司）邮箱 
 * 3.团队成员密码 mpassword varchar 255 需要用到AES加密
 * 4.团队成员姓名 mname varchar 20 汉字
 * 5.团队成员注册日期 mdate varchar/date 50 可能会使用date来进行数据库计算或者使用String到Java端来进行计算
 * 6.团队成员照片 mimage varchar 255 照片路径
 * 7.团队成员其他信息 mqa varchar 255 使用键值对来进行存储 弹性较大 类似于这样{“性别”:”男”,”身份证号码：”“220112xxxxx”};
 * 8.团队成员状态 mstatus varchar 50 用户的状态 没有使用int更多是为了弹性。因为后台就算是判断也是session进行枚举比对
 * 9.团队成员简历 minfo varchar 1000 用户的简历 使用超文本格式
 * </pre>
 * <p>Describe: 团队成员类模型</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午4:32:14</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class Member implements Serializable {

	private static final long serialVersionUID = -7382123604352223621L;

	private Integer mid;

	private String musername;

	private String mpassword;

	private String mname;

	private String mdate;

	private String mimage;

	private String mqa;

	private String mstatus;

	private String minfo;

	/**
	 * <p>Describe: 团队成员——项目组 多对多</p>
	 * <p>Using: </p>
	 */
	private Set<Team> teams;

	/**
	 * <p>Describe: 任务接受夹</p>
	 * <p>Using: </p>
	 */
	private Set<Task> taskFromOther;

	/**
	 * <p>Describe: 任务发送夹</p>
	 * <p>Using: </p>
	 */
	private Set<Task> taskToOther;

	/**
	 * <p>Describe: 发信夹</p>
	 * <p>Using: SELECT DISTINCT
	mes.mesid,
	mes.mestitle,
	mes.mesdes,
	mes.messtatus,
	mes.mesinfo,
	mes.mesdate
	FROM member_database m , message_database mes, message_member_database mmd
	where mes.mesid = mmd.mesid and (mmd.mfromid = m.mid or mmd.mtoid = m.mid) and mmd.mfromid = id本身</p>
	 */
	private Set<Message> messageToOther;

	/**
	 * <p>Describe: 收件夹</p>
	 * <p>Using: SELECT DISTINCT
	mes.mesid,
	mes.mestitle,
	mes.mesdes,
	mes.messtatus,
	mes.mesinfo,
	mes.mesdate
	FROM member_database m , message_database mes, message_member_database mmd
	where mes.mesid = mmd.mesid and (mmd.mfromid = m.mid or mmd.mtoid = m.mid) and mmd.mtoid = id本身</p>
	 */
	private Set<Message> messageFromOther;

	private Set<Notification> notifications;

	private Set<Role> posts;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMusername() {
		return musername;
	}

	public void setMusername(String musername) {
		this.musername = musername;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMimage() {
		return mimage;
	}

	public void setMimage(String mimage) {
		this.mimage = mimage;
	}

	public String getMqa() {
		return mqa;
	}

	public void setMqa(String mqa) {
		this.mqa = mqa;
	}

	public String getMstatus() {
		return mstatus;
	}

	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}

	public String getMinfo() {
		return minfo;
	}

	public void setMinfo(String minfo) {
		this.minfo = minfo;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", musername=" + musername
				+ ", mpassword=" + mpassword + ", mname=" + mname + ", mdate="
				+ mdate + ", mimage=" + mimage + ", mqa=" + mqa + ", mstatus="
				+ mstatus + ", minfo=" + minfo + "]";
	}

	public Member(Integer mid, String musername, String mpassword,
			String mname, String mdate, String mimage, String mqa,
			String mstatus, String minfo) {
		super();
		this.mid = mid;
		this.musername = musername;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mdate = mdate;
		this.mimage = mimage;
		this.mqa = mqa;
		this.mstatus = mstatus;
		this.minfo = minfo;
	}

	public Member(String musername, String mpassword, String mname,
			String mdate, String mimage, String mqa, String mstatus,
			String minfo) {
		super();
		this.musername = musername;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mdate = mdate;
		this.mimage = mimage;
		this.mqa = mqa;
		this.mstatus = mstatus;
		this.minfo = minfo;
	}

	public Member() {
	}

	public Set<Message> getMessageToOther() {
		return messageToOther;
	}

	public void setMessageToOther(Set<Message> messageToOther) {
		this.messageToOther = messageToOther;
	}

	public Set<Message> getMessageFromOther() {
		return messageFromOther;
	}

	public void setMessageFromOther(Set<Message> messageFromOther) {
		this.messageFromOther = messageFromOther;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Task> getTaskFromOther() {
		return taskFromOther;
	}

	public void setTaskFromOther(Set<Task> taskFromOther) {
		this.taskFromOther = taskFromOther;
	}

	public Set<Task> getTaskToOther() {
		return taskToOther;
	}

	public void setTaskToOther(Set<Task> taskToOther) {
		this.taskToOther = taskToOther;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Set<Role> getPosts() {
		return posts;
	}

	public void setPosts(Set<Role> posts) {
		this.posts = posts;
	}

	/**
	 * <p>Describe: 解密</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月19日下午8:10:56 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	public void Decrypt() {
		mpassword = AESLocker.Decrypt(mpassword);
		System.out.println("UnLocking");
	}

	/**
	 * <p>Describe: 加密</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月19日下午8:10:49 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	public void Encrypt() {
		mpassword = AESLocker.Encrypt(mpassword);
		System.out.println("Locking");
	}

}
