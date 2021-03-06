package org.jichuang.hope6537.base.model;

import org.jichuang.hope6537.utils.AESLocker;

import javax.persistence.*;
import java.io.Serializable;

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
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "Member")
public class Member implements Serializable {

    private static final long serialVersionUID = -7382123604352223621L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberId", length = 50)
    private Integer memberId;
    @Column(name = "username", length = 50)
    private String username;
    @Column(name = "password", length = 128)
    private String password;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "date", length = 50)
    private String date;
    @Column(name = "image", length = 255)
    private String image;
    @Column(name = "qa", length = 500)
    /**
     * 关于QA和其他类的INFO的存储方式的设想
     * 一开始的时候打算使用Map<String,List<String>>进行存储的
     * 后来发现这个并不利于使用
     * 现在打算转换为JSON格式
     * 但是JSON有几个小疑问
     * 1、如何添加键值对对象？
     * 2、如何在页面上显示？
     * 3、如何取出解析?
     * 那么就必须要写出JSON的工具类了
     */
    private String qa;
    @Column(name = "status", length = 50)
    private String status;
    /**
     *
     */
    @Column(name = "info", length = 10000)
    private String info;
    @Transient
    private String postId;

    /**
     * <p>Describe: 解密</p>
     * <p>Using: </p>
     * <p>How To Work: </p>
     * <p>DevelopedTime: 2014年10月19日下午8:10:56 </p>
     * <p>Author:Hope6537</p>
     *
     * @see
     */
    public void Decrypt() {
        password = AESLocker.Decrypt(password);
        System.out.println("UnLocking");
    }

    /**
     * <p>Describe: 加密</p>
     * <p>Using: </p>
     * <p>How To Work: </p>
     * <p>DevelopedTime: 2014年10月19日下午8:10:49 </p>
     * <p>Author:Hope6537</p>
     *
     * @see
     */
    public void Encrypt() {
        password = AESLocker.Encrypt(password);
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQa() {
        return qa;
    }

    public void setQa(String qa) {
        this.qa = qa;
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


    @Override
    public String toString() {
        return "Member{" +
                "info='" + info + '\'' +
                ", status='" + status + '\'' +
                ", qa='" + qa + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", memberId=" + memberId +
                '}';
    }


}
