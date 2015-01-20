package org.jichuang.hope6537.notification.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 九.通知对象 Notification  —— 数据库表
 * 1、通知id nid int 10
 * 2、通知内容 ninfo varchar 10
 * 3、通知时间 ndate varchar 255
 * 4、通知发起人 nmid int 10
 * 5、通知其他信息：键值对 ninfo varchar 255
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午7:48:12</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "Notification")
public class Notification implements Serializable {

    /**
     * <p>Describe: </p>
     * <p>Using: </p>
     */
    private static final long serialVersionUID = -1014917383769235149L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notificationId", length = 50)
    private Integer notificationId;

    @Column(name = "des", length = 150)
    private String des;

    @Column(name = "date", length = 150)
    private String date;

    @Column(name = "info", length = 50)
    private String info;

    public Notification() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}