package com.hjb.springbootshiro.sevice;

import com.hjb.springbootshiro.entity.News;

import java.util.List;

public interface NewsServlet {
    List<News> listAllNews();

    void addNews(News news);

    void delNews(News news);

}
