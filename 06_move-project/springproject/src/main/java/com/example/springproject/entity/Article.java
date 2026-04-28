package com.example.springproject.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@ToString
@Slf4j
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // 생성자 (DTO → Entity 변환 시 사용)
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 로그 출력
    public void logInfo() {
        log.info("id: {}, title: {}, content: {}", id, title, content);
    }
}
