package com.example.springproject.controller;

import com.example.springproject.Article;
import com.example.springproject.ArticleUpdateForm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ArticleController {

    // 데이터 수정을 위해 원본 데이터 가져오기
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/edit";
    }

    // 수정 데이터 DB 갱신
    @PostMapping("/articles/update")
    public String updateArticle(ArticleUpdateForm articleUpdateForm){
        log.info(" " + articleUpdateForm.toString());

        //DTO의 id로 기존 Entity를 DB로부터 가져온다.
        Article target = articleRepository.findById(articleUpdateForm.getId()).orElse(null);
        //2. 대상이 있을때만 수정 로직 진행 ( 기존 Entity 내용에 updateDTO 내용 덮어쓰기 )
        if(target != null){
            // 기존 Entity에 수정 DTO의 내용을 덮어 씌움
            target.patch(articleUpdateForm);
            // 변경된 target을 저장
            articleRepository.save(target);
            log.info("수정 완료: " + target.toString());
        }else {
            log.info("수정 실패: 대상 엔티티가 없습니다. ID=" + articleUpdateForm.getId());
        }
        // 결과 페이지 리다이렉트
        return "redirect:/articles/" + articleUpdateForm.getId();
    }

    // 단일 데이터 조회 요청 접수
    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        log.info("id = {} ", id);
        //1. id를 조회하여 article 데이터 가져오기
        //Optional<Article> article = articleRepository.findById(id);
        Article article = articleRepository.findById(id).orElse(null);
        //2. 모델에 등록하기
        model.addAttribute("article", article);
        //3. 뷰 페이지 반환
        return "articles/show";
    }

}
