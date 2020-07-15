package com.kunguo.linghuawang.service.impl;

import com.kunguo.linghuawang.dao.NoticeMapper;
import com.kunguo.linghuawang.pojo.Notice;
import com.kunguo.linghuawang.service.NoticeService;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: NoticeServiceImpl
 * @Description:
 * @date 2020/6/30
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public String addNotice(Notice notice) {
        ResultJson resultJson = new ResultJson();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式/
        notice.setNoticetime(df.format(new Date()));
        int code = noticeMapper.insert(notice);
        if (code>0){
            resultJson.setMsg("添加成功");
        }else {
            resultJson.setCode(401);
            resultJson.setMsg("添加失败");
        }
        return resultJson.getJson();
    }

    @Override
    public String selectAllNotice(String title) {
        ResultJson resultJson = new ResultJson();
        List<Notice> list =  noticeMapper.selectAllNotice(title);
        resultJson.setObj(list);
        resultJson.setCount(list.size());
        resultJson.setMsg("");
        return  resultJson.getJson() ;
    }

    @Override
    public String updateNotice(Notice notice) {
        ResultJson resultJson = new ResultJson();
        int result = noticeMapper.updateByPrimaryKeySelective(notice);
        if (result==0){
            resultJson.setCode(401);
            resultJson.setMsg("修改失败");
        }else {
            resultJson.setMsg("修改成功");
        }
        return resultJson.getJson();
    }

    @Override
    public String delNotice(String ids) {
        ResultJson resultJson = new ResultJson();
        int result = noticeMapper.deleteByPrimaryKey(ids);
        if (result==0){
            resultJson.setCode(401);
        }else {
            resultJson.setMsg("删除成功");
        }
        return resultJson.getJson();
    }
}
