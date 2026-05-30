package com.example.springproject.controller;

import com.example.springproject.dto.ArticleForm;
import com.example.springproject.dto.ArticleUpdateForm;
import com.example.springproject.entity.Article;
import com.example.springproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Sl4fj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    // 게시글 목록 보기
    @GetMapping
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles/index";
    }

    // 게시글 작성 폼
    @GetMapping("/new")
    public String newArticleForm() {
        return "articles/new";
    }

    // 게시글 저장
    @GetMapping("/create")
    public String createArticle(ArticleForm articleForm, Model model) {
        log.info("{}", articleForm);

        Article article = articleForm.toEntity();
        Article saved = articleRepository.save(article);

        // 리스트 페이지로 redirect
        return "redirect:/articles"+ saved.getId();
    }

    // 단일 데이터 조회 (상세보기)
    @GetMapping("/{id}")
    public String show(@PathVariable("id")Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/show";
    }

    // 데이터 수정 불러오기
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/edit";
    }

    // 수정된 데이터 DB에 저장
    @PostMapping("/update")
    public String update(ArticleForm articleForm) {
        log.info("{}", articleForm);

        // DTO to Entity
        Article article = articleForm.toEntity();
        // entity 확인
        log.info("{}", article);

        // find whether entity or not
        Article target = articleRepository.findById(article.getId()).orElse(null);
        if(target != null) {
            articleRepository.save(article);   // update article entity
        }

        return "redirect:/articles/" + target.getId();
    }

    // 데이터 삭제
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes rttr){
        Article target = articleRepository.findById(id).orElse(null);
        // 해당 id에 맞는 article이 존재하는지 확인
        if(target != null) {
            // 존재한다면, repository를 통해서 delete 작업
            articleRepository.deleteById(id);
            // 삭제 완료 메시지
            rttr.addFlashAttribute("msg", " .");
        }
        // index 리스트페이지로 redirect
        return "redirect:/articles";
    }
}
