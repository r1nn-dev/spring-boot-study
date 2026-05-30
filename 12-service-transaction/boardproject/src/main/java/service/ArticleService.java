package service;

import com.example.boardproject.dto.ArticleForm;
import com.example.boardproject.dto.ArticleUpdateForm;
import com.example.boardproject.entity.Article;

import java.util.List;

public interface ArticleService {

    //read All Article
    List<Article> index();

    //Read one Article
    Article show(Long id);

    //Insert
    Article create(ArticleForm articleForm);

    //Update Article
    Article update(Long id, ArticleUpdateForm articleUpdateForm);

    //Delete Article
    Article delete(Long id);
}
