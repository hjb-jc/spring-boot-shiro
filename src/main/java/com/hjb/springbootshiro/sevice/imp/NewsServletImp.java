package com.hjb.springbootshiro.sevice.imp;

import com.hjb.springbootshiro.dao.NewsDao;
import com.hjb.springbootshiro.entity.News;
import com.hjb.springbootshiro.sevice.NewsServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServletImp implements NewsServlet {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> listAllNews() {
        return newsDao.findAll();
    }

    @Override
    public void addNews(News news) {
        newsDao.save(news);
    }

    @Override
    public void delNews(News news) {
        newsDao.delete(news);
    }
}
