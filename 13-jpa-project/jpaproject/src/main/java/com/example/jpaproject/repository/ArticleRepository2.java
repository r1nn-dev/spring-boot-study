package com.example.jpaproject.repository;

import com.example.jpaproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository2 extends JpaRepository<Article, Long> {

    //1. 메서드 이름 기반 쿼리 메서드

    //title이 "keyword"인 article 리스트 가져오기
    List<Article> findByTitle(String keyword);

    //타이틀이 "keyword"를 포함하고 있는 리스트의 갯수 가져오기
    List<Article> findByTitleContaining(String keyword);

    //content가 "keyword"을 포함하고 있는 article 리스트 가져오기
    List<Article> findByContentContaining(String keyword);

    //2. JPQL 쿼리 메서드
    @Query("SELECT a from Article a where a.title = :title")
    List<Article> findByTitle2(@Param("title") String title);

    //JPQL로 ID가 1에서 3 사이인 article 가져오기
    @Query("Select a from Article a where a.id between :s_id and :e_id")
    List<Article> findArticlesInRange(@Param("s_id") Long s_id, @Param("e_id") Long e_id);

    //특정 ID목록에 포함된 article 조회
    @Query("Select a from Article a where a.id in :ids")
    List<Article> findByIdsIn(@Param("ids") List<Long> ids);

}
