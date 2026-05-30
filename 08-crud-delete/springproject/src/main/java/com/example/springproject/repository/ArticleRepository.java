package com.example.springproject.repository;

import com.example.springproject.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.List;

@Repository
public class ArticleRepository {
    /*
    Iterable<Article>은 더 일반적, 다양한 구현체를 허용
    List<Article> 더 구체적이고, 기능 많지만 제한적
     */
    @Override
    List<Article> findAll();
}
