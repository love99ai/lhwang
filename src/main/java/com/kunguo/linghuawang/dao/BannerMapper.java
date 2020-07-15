package com.kunguo.linghuawang.dao;

import com.kunguo.linghuawang.pojo.Banner;

import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(String ids);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectAllBanner(String title);

}