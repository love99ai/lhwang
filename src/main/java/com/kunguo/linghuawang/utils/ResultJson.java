package com.kunguo.linghuawang.utils;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaomaohui
 * @ClassName: ResultJson
 * @Description:
 * @date 2020/5/19
 */
public class ResultJson {

    private int code; //默认状态成功
    private String msg;
    private Object obj;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getJson(){

        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",obj);
        map.put("count",count);
        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
        return gson.toJson(map);

    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",obj);
        map.put("count",count);
        return map;
    }

}
