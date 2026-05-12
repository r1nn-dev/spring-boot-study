package com.example.boardproject.dto;

import com.example.boardproject.entity.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString @Slf4j
public class ArticleUpdateDTO {
    private Long id;
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(id, title, content);
    }

    public void logInfo(){
        log.info("title:{},content:{}",title,content);
    }
}

