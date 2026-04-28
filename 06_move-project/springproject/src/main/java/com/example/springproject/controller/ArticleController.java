package com.example.springproject.controller;

import com.example.springproject.dto.ArticleForm;
import com.example.springproject.entity.Article;
import com.example.springproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    // Repository 자동 주입 (DI)
    private final ArticleRepository articleRepository;

    // 글 작성 페이지
    @GetMapping("/articles/new")
    public String newArticle() {
        return "articles/new";
    }

    // 글 생성 처리
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {

        // 1. DTO 로그 출력
        articleForm.logInfo();

        // 2. DTO → Entity 변환
        Article article = articleForm.toEntity();
        article.logInfo();

        // 3. DB 저장
        Article saved = articleRepository.save(article);
        saved.logInfo();

        return "";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {

        // DTO 내부 로그 출력
        articleForm.logInfo();

        // 콘솔 출력
        System.out.println(articleForm);

        // 이후 단계에서 DB 저장 진행 (현재는 여기까지)
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {

        // 1. id로 데이터 조회 (Optional 반환)
        // Optional<Article> articleOpt = articleRepository.findById(id);

        // Optional → 값 꺼내기 (없으면 null)
        Article article = articleRepository.findById(id).orElse(null);

        // 2. Model에 데이터 등록
        model.addAttribute("article", article);

        // 3. View 반환
        return "articles/show";
    }

    @GetMapping("/articles")
    public String list(Model model) {

        // 1. 전체 데이터 조회
        List<Article> articleList = articleRepository.findAll();

        // 2. Model 등록
        model.addAttribute("articleList", articleList);

        // 3. View 반환
        return "articles/index";
    }
}
