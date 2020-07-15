package com.kunguo.linghuawang.service.impl;

import com.kunguo.linghuawang.dao.NewsMapper;
import com.kunguo.linghuawang.pojo.News;
import com.kunguo.linghuawang.service.NewsService;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: NewsServiceImpl
 * @Description:
 * @date 2020/6/29
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public String addNews(News news) {
        ResultJson resultJson = new ResultJson();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式/
        news.setNewstime(df.format(new Date()));
        news.setIsopen(true);
        int code = newsMapper.insert(news);
        if (code>0){
            resultJson.setMsg("添加成功");
        }else {
            resultJson.setCode(401);
            resultJson.setMsg("添加失败");
        }
        return resultJson.getJson();
    }


    @Override
    public String selectAllNews(String title) {
        ResultJson resultJson = new ResultJson();
        List<News> list =  newsMapper.selectAllNews(title);
        resultJson.setObj(list);
        resultJson.setCount(list.size());
        resultJson.setMsg("");
        return  resultJson.getJson() ;
    }

    @Override
    public String updateNews(News news) {
        ResultJson resultJson = new ResultJson();
        int result = newsMapper.updateByPrimaryKeySelective(news);
        if (result==0){
            resultJson.setCode(401);
            resultJson.setMsg("修改失败");
        }else {
            resultJson.setMsg("修改成功");
        }
        return resultJson.getJson();
    }

    @Override
    public String updateNewsOpen(int newsId, boolean isOpen) {
        ResultJson resultJson = new ResultJson();
        int result = newsMapper.updateNewsOpen(newsId,isOpen);
        if (result==0){
            resultJson.setCode(401);
        }
        return resultJson.getJson();
    }

    @Override
    public String delNews(String ids) {
        ResultJson resultJson = new ResultJson();
        int result = newsMapper.deleteByPrimaryKey(ids);
        if (result==0){
            resultJson.setCode(401);
        }else {
            resultJson.setMsg("删除成功");
        }
        return resultJson.getJson();
    }
}
