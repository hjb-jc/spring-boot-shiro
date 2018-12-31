package com.hjb.springbootshiro.dao;

import com.hjb.springbootshiro.entity.News;
import com.hjb.springbootshiro.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDao extends JpaRepository<News, Integer> {

}
