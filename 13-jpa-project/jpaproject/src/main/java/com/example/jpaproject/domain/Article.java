package com.example.jpaproject.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
@Slf4j
@Table(name = "article")
public class Article {

    @Id   //기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가
    private int id;

    @Column(nullable = false, length = 100) //not null, 길이 제한
    private String title;

    @Lob //긴 텍스트를 위한 필드 (Large Object)
    private String content;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public void articleInfo(){
        log.info("Article Info - id = {}, title = {}, created = {}", id, title, createdAt);
    }
}
