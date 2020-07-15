package com.kunguo.linghuawang.pojo;

import java.util.Date;

public class RoleRights {
    private Integer id;

    private String tasktitle;

    private String taskdesc;

    private Integer taskclassid;

    private Date createtime;

    private Boolean taskstate;

    private Boolean isnum;

    private Integer tasknum;

    private Integer tasklastnum;

    private String taskcontent;

    public Integer getId() {
        return id;
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

    public Integer getTaskclassid() {
        return taskclassid;
    }

    public void setTaskclassid(Integer taskclassid) {
        this.taskclassid = taskclassid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getTaskstate() {
        return taskstate;
    }

    public void setTaskstate(Boolean taskstate) {
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

    public String getTaskcontent() {
        return taskcontent;
    }

    public void setTaskcontent(String taskcontent) {
        this.taskcontent = taskcontent == null ? null : taskcontent.trim();
    }
}