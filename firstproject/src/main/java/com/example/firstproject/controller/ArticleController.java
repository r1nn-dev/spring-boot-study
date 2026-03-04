package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller  // 컨트롤러 선언 - 이 파일이 컨트롤러임을 선언
public class ArticleController {

    @Autowired // 스프리 부트가 미리 생성해놓은 객체를 가져다가 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")   // URL 요청 접수 - 메서드가 요청을 처리하도록 매핑
    // newArticleForm() 메서드 작성
    public String newArticleForm() {
        // 뷰 이름 반환
        // template/new.mustache -> 브라우저로 전송 - 뷰 템플릿 페이지 반환
        // 서버가 templates 디렉터리에서 파일 찾아 웹 브라우저로 전송
        return "articles/new";
    }

    @PostMapping("/articles/create")   // URL 요청 접수 - 메서드가 요청을 처리하도록 매핑
    // createArticle() 메서드 작성
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        // 1. DTO 변환 - Entity
        Article article = form.toEntity();
        System.out.println(article.toString());
        // 2. Repository에게 Entity를 DB에 저장하게 한다.
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
