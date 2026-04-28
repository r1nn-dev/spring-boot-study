package com.example.springproject.controller;

import com.example.springproject.dto.ArticleForm;
import com.example.springproject.entity.Article;
import com.example.springproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        Article article = articleForm.toEntity();
        Article saved = articleRepository.save(article);

        //<상세 페이지> 이동
        return "redirect:/articles/" + saved.getId();

    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {

        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/show";
    }

    @GetMapping("/articles")
    public String list(Model model) {

        // 1. 전체 데이터 조회
        List<Article> articleList = (List<Article>) articleRepository.findAll();

        // 2. Model 등록
        model.addAttribute("articleList", articleList);

        // 3. View 반환
        return "articles/index";
    }
}
