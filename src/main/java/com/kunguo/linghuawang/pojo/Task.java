package com.kunguo.linghuawang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


public class Task {
    private Integer id;

    private String tasktitle;

    private String taskdesc;

    private String taskclassid;

    private String createtime;

    private int taskstate;

    private Boolean isnum;

    private Integer tasknum;

    private Integer tasklastnum;

    private String taskimg;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String releasetime;

    private Double taskprice;

    private String taskcontent;

    private String taskurl;

    public String getTaskurl() {
        return taskurl;
    }

    public void setTaskurl(String taskurl) {
        this.taskurl = taskurl;
    }

    public Integer getId() {
        return id;
    }

    public String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle == null ? null : tasktitle.trim();
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc == null ? null : taskdesc.trim();
    }

    public String getTaskclassid() {
        return taskclassid;
    }

    public void setTaskclassid(String taskclassid) {
        this.taskclassid = taskclassid == null ? null : taskclassid.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getTaskstate() {
        return taskstate;
    }

    public void setTaskstate(int taskstate) {
        this.taskstate = taskstate;
    }

    public Boolean getIsnum() {
        return isnum;
    }

    public void setIsnum(Boolean isnum) {
        this.isnum = isnum;
    }

    public Integer getTasknum() {
        return tasknum;
    }

    public void setTasknum(Integer tasknum) {
        this.tasknum = tasknum;
    }

    public Integer getTasklastnum() {
        return tasklastnum;
    }

    public void setTasklastnum(Integer tasklastnum) {
        this.tasklastnum = tasklastnum;
    }

    public String getTaskimg() {
        return taskimg;
    }

    public void setTaskimg(String taskimg) {
        this.taskimg = taskimg == null ? null : taskimg.trim();
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public Double getTaskprice() {
        return taskprice;
    }

    public void setTaskprice(Double taskprice) {
        this.taskprice = taskprice;
    }

    public String getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(String taskcontent) {
        this.taskcontent = taskcontent == null ? null : taskcontent.trim();
    }
}