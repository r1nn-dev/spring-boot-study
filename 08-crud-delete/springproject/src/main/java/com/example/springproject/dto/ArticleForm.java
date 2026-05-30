package com.example.springproject.dto;

import com.example.springproject.entity.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor @AllArgsConstructor @Getter  @Setter @ToString
@Slf4j
public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(title, content);
    }

    public void logInfo(){
        log.info("title:{},content:{}",title,content);
    }
}
