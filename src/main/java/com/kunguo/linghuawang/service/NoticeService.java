package com.kunguo.linghuawang.service;

import com.kunguo.linghuawang.pojo.Notice;

/**
 * @author zhaomaohui
 * @ClassName: NoticeService
 * @Description:
 * @date 2020/6/30
 */
public interface NoticeService {

    public String addNotice(Notice notice);
    public String selectAllNotice(String title);
    public String updateNotice(Notice notice);
    public String delNotice(String ids);
}
