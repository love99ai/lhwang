package com.kunguo.linghuawang.service;

import com.kunguo.linghuawang.pojo.News;

public interface NewsService {
    public String addNews(News news);
    public String selectAllNews(String title);
    public String updateNews(News news);
    public String updateNewsOpen(int newsId,boolean isOpen);
    public String delNews(String ids);
}
