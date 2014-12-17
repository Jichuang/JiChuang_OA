package org.jichuang.hope6537.task.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 * 十三.任务对象 Task —— 数据库表
 * 1.任务主键id taskid int 10
 * 2.任务发起人 taskfrom_mid int 10 一个
 * （源任务接收人被改为多对多）
 * 3.任务描述 taskdes varchar 255
 * 4.任务发起时间 taskstart varchar 255
 * 5.任务截止期限 taskdead varchar 255
 * 6.任务结束时间 taskend varchar 255
 * 7.任务状态 taskstatus varchar 50
 * 8.任务其他信息 taskinfo varchar 255
 * </pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午8:07:23</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 *
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "Task")
public class Task implements Serializable {

    /**
     * <p>Describe: </p>
     * <p>Using: </p>
     */
    private static final long serialVersionUID = 1884133633273726805L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskId")
    private Integer taskId;
    @Column(name = "des", length = 500)
    private String des;
    @Column(name = "start", length = 50)
    private String start;
    @Column(name = "dead", length = 50)
    private String dead;
    @Column(name = "end", length = 50)
    private String end;
    @Column(name = "status", length = 50)
    private String status;
    @Column(name = "info", length = 500)
    private String info;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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
        return "Task{" +
                "taskId=" + taskId +
                ", des='" + des + '\'' +
                ", start='" + start + '\'' +
                ", dead='" + dead + '\'' +
                ", end='" + end + '\'' +
                ", status='" + status + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
