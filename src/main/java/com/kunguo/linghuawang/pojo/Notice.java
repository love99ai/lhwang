package com.kunguo.linghuawang.pojo;

import java.util.Date;

public class Notice {
    private Integer id;

    private String noticetitle;

    private String noticeimg;

    private String noticetime;

    private String noticecontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticetitle() {
        return noticetitle;
    }

    public void setNoticetitle(String noticetitle) {
        this.noticetitle = noticetitle == null ? null : noticetitle.trim();
    }

    public String getNoticeimg() {
        return noticeimg;
    }

    public void setNoticeimg(String noticeimg) {
        this.noticeimg = noticeimg == null ? null : noticeimg.trim();
    }

    public String getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(String noticetime) {
        this.noticetime = noticetime;
    }

    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent == null ? null : noticecontent.trim();
    }
}