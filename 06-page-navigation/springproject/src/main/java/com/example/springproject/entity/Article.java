package com.example.springproject.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@ToString
@Slf4j
public class Article {

    @Setter
    @Getter
    @jakarta.persistence.Id
    private Long id1;
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

    public Article() {

    }

    public String getId() {
        return "";
    }
}
