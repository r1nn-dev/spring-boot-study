package com.example.springproject.dto;

import com.example.springproject.entity.Article;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter                     // getter 자동 생성
@Setter                     // setter 자동 생성
@NoArgsConstructor          // 기본 생성자 생성
@AllArgsConstructor         // 모든 필드 생성자 생성
@ToString                   // toString() 자동 생성
@Slf4j                      // Logger 자동 생성
public class ArticleForm {

    private String title;
    private String content;

    // DTO → Entity 변환
    public Article toEntity() {
        return new Article(title, content);
    }

    public void logInfo() {
        log.info("title: {}, content: {}", title, content);
    }
}
