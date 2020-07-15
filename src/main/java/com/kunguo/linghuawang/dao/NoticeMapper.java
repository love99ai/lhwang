package com.kunguo.linghuawang.dao;

import com.kunguo.linghuawang.pojo.Notice;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(String ids);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> selectAllNotice(String title);
}