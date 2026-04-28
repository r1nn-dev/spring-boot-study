package com.example.springproject.repository;

import com.example.springproject.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository extends CrudRepository<Article, Long> {

}
