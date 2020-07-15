package com.kunguo.linghuawang.pojo;


public class Banner {
    private Integer id;

    private String bannertitle;

    private String bannerimg;

    private String createtime;

    private Boolean bannertype;

    private Integer otherid;

    private Integer index;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBannertitle() {
        return bannertitle;
    }

    public void setBannertitle(String bannertitle) {
        this.bannertitle = bannertitle == null ? null : bannertitle.trim();
    }

    public String getBannerimg() {
        return bannerimg;
    }

    public void setBannerimg(String bannerimg) {
        this.bannerimg = bannerimg == null ? null : bannerimg.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Boolean getBannertype() {
        return bannertype;
    }

    public void setBannertype(Boolean bannertype) {
        this.bannertype = bannertype;
    }

    public Integer getOtherid() {
        return otherid;
    }

    public void setOtherid(Integer otherid) {
        this.otherid = otherid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}