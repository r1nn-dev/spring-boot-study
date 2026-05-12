package com.example.boardproject.api;

import com.example.boardproject.dto.ArticleDTO;
import com.example.boardproject.entity.Article;
import com.example.boardproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/articles")
public class ArticleApiController {

    private final ArticleRepository articleRepository;

    // read all
    @GetMapping
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    // read one article 단일 게시글 조회
    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // insert
    @PostMapping
    public Article createArticle(@RequestBody ArticleDTO articleDTO) {
        log.info("Creating article: {}", articleDTO);
        Article article = articleDTO.toEntity();
        log.info("Saving article: {}", article);
        Article saved = articleRepository.save(article);
        return saved;
    }

    /*
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleDTO articleDTO){
        log.info("Creating article {}", articleDTO);

        Article article = articleDTO.toEntity();
        log.info("Saving article {}", article);

        Article saved = articleRepository.save(article);
        return ResponseEntity.ok(saved);
    }
    */


    // patch
    // 수정할 데이터는 바뀌고 기존 데이터는 그대로 있도록 하는 patch method 정의
    // http://localhost:8080/api/articles/1
    @PatchMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateDTO articleUpdateDTO) {

        // 없다면 잘못된 요청 처리
        // 요청 데이터 검증
        if(id != articleUpdateDTO.getId()){
            log.warn("ID 불일치 pathId={}, bodyId={}", id, articleUpdateDTO.getId());

            //return ResponseEntity.badRequest().body(null);
            return ResponseEntity.badRequest().build();
        }

        //수정 Entity가 존재하는지 확인
        Article target = articleRepository.findById(id).orElse(null);

        // 대상 없음
        if (target == null) {
            log.warn("존재하지 않는 게시글 수정 요청 id={}", id);
            return ResponseEntity.notFound().build();
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //수정
        target.patch(articleUpdateDTO);
        Article updated = articleRepository.save(target);

        return ResponseEntity.ok(updated);
        //return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id) {
        log.info("Deleting article {}", id);
        //해당 delete 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 존재하지 않으면 잘못된 처리
        if(target == null){
            log.warn("id = {}에 존재하는 게시글이 없습니다." , id);
            return ResponseEntity.notFound().build();
        }
        // 존재하면 삭제
        articleRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
