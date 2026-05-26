package com.example.jpaproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.Sort;

@DataJpaTest
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void contextLoad() {
        //id로 검색
        articleRepository.findById(2L).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Article Not Found")
        );

        //Article List 가져오기
        articleRepository.findAll().forEach(System.out::println);

        //Article List 가져오기(id 역순으로 정렬)
        articleRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .forEach(System.out::println);

        //Article 갯수 출력
        long count = articleRepository.count();
        System.out.println(count);
    }

}
