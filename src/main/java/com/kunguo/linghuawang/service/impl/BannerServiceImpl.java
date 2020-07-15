package com.kunguo.linghuawang.service.impl;

import com.kunguo.linghuawang.dao.BannerMapper;
import com.kunguo.linghuawang.pojo.Banner;
import com.kunguo.linghuawang.service.BannerService;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: BannerServiceImpl
 * @Description:
 * @date 2020/6/30
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public String addBanner(Banner banner) {
        ResultJson resultJson = new ResultJson();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式/
        banner.setCreatetime(df.format(new Date()));
        int code = bannerMapper.insert(banner);
        if (code>0){
            resultJson.setMsg("添加成功");
        }else {
            resultJson.setCode(401);
            resultJson.setMsg("添加失败");
        }
        return resultJson.getJson();
    }

    @Override
    public String selectAllBanner(String title) {
        ResultJson resultJson = new ResultJson();
        List<Banner> list =  bannerMapper.selectAllBanner(title);
        resultJson.setObj(list);
        resultJson.setCount(list.size());
        resultJson.setMsg("");
        return  resultJson.getJson() ;
    }

    @Override
    public String updateBanner(Banner banner) {
        ResultJson resultJson = new ResultJson();
        int result = bannerMapper.updateByPrimaryKeySelective(banner);
        if (result==0){
            resultJson.setCode(401);
            resultJson.setMsg("修改失败");
        }else {
            resultJson.setMsg("修改成功");
        }
        return resultJson.getJson();
    }

    @Override
    public String delBanner(String ids) {
        ResultJson resultJson = new ResultJson();
        int result = bannerMapper.deleteByPrimaryKey(ids);
        if (result==0){
            resultJson.setCode(401);
        }else {
            resultJson.setMsg("删除成功");
        }
        return resultJson.getJson();
    }
}
