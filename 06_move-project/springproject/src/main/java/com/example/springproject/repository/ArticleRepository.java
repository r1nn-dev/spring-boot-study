package com.example.springproject.repository;

import com.example.springproject.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class ArticleRepository implements CrudRepository<Article, Long> {

}
