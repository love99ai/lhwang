package com.kunguo.linghuawang.service;

import com.kunguo.linghuawang.pojo.Banner;

public interface BannerService {

    public String addBanner(Banner banner);
    public String selectAllBanner(String title);
    public String updateBanner(Banner banner);
    public String delBanner(String ids);
}
