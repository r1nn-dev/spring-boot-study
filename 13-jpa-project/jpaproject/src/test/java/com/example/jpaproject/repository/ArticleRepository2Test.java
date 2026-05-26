package com.example.jpaproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ArticleRepository2Test {

    @Autowired
    private ArticleRepository2 articleRepository;

    //title이 "keyword"인 article 리스트 가져오기
    @Test
    public void findByTitleTest(){
        articleRepository.findByTitle("Entity란?")
                .forEach(System.out::println);
    }

    //타이틀이 "keyword"를 포함하고 있는 리스트의 갯수 가져오기
    @Test
    public void findByTitleContainingTest() {
        articleRepository.findByTitleContaining("Spring")
                .forEach(System.out::println);
    }

    //content가 "keyword"을 포함하고 있는 article 리스트 가져오기
    @Test
    public void findByContentContainingTest(){
        articleRepository.findByContentContaining("JPA")
                .forEach(System.out::println);
    }

    @Test
    public void findByTitle2(){
        articleRepository.findByTitle2("JPA")
                .forEach(System.out::println);
    }
    @Test
    public void findArticlesInRange(){
        articleRepository.findArticlesInRange(2L, 5L)
                .forEach(System.out::println);
    }
    @Test
    public void findByIdsInTest(){
        articleRepository.findByIdsIn(List.of(1L, 2L, 5L))
                .forEach(System.out::println);
    }

}
