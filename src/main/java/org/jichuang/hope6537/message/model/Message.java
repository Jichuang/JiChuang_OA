package org.jichuang.hope6537.message.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 十二.私信对象 Message —— 数据库表/可能会使用XML进行映射
 * 1.私信主键id mesid int 10
 * 2.私信发信人 mesfrom_mid int 10 对应单一
 * 3.私信收信人 改为多对多
 * 4.私信标题 mestitle varchar 50
 * 5.私信内容 mesdes varchar 500
 * 6.私信时间 mesdate varchar 50
 * 7.私信状态 messtatus varchar 50
 * 8.私信其他信息：键值对 mesifno varchar 255
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:07:06</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "Message")
public class Message implements Serializable {
    /**
     * <p>Describe: </p>
     * <p>Using: </p>
     */
    private static final long serialVersionUID = 1505144897024599779L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "messageId", length = 50)
    private Integer messageId;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "des", length = 500)
    private String des;
    @Column(name = "date", length = 50)
    private String date;
    @Column(name = "status", length = 50)
    private String status;
    @Column(name = "info", length = 500)
    private String info;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "Message{" +
                "mesId=" + getMessageId() +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
