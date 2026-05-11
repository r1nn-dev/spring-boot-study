package com.example.springproject.entity;

import com.example.springproject.dto.ArticleUpdateForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //DB가 PK 직접 생성
    Long id;
    private String title;
    private String content;


    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
    public void logInfo(){
        log.info("id: {}, title:{}, content:{}", id, title, content);
    }

    //수정 전용 메서드(patch)
    //Dirty Checking (DB 부하 감소): JPA에서 조회온 Entity의 값을 변경하면, 트랜잭션이 끝날때 알아서 DB에 반영
    public void patch(ArticleUpdateForm dto){
        if(dto.getTitle() != null)
            this.title = dto.getTitle();
        if(dto.getContent() != null){
            this.content = dto.getContent();
        }
    }

}
