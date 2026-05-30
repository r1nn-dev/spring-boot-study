package com.example.boardproject.repository;

import com.example.boardproject.entity.Article;

import java.lang.ScopedValue;
import java.util.List;

public class ArticleRepository {
    public Article save(Article article) {
        return article;
    }

    public ScopedValue<Object> findById(Long id) {
        return null;
    }

    public List<Article> findAll() {
        return List.of();
    }

    public void delete(Article target) {
    }
}
