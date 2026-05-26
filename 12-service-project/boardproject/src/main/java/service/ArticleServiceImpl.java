package service;

import com.example.boardproject.dto.ArticleForm;
import com.example.boardproject.dto.ArticleUpdateForm;
import com.example.boardproject.entity.Article;
import com.example.boardproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Sl4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    /* READ
    */
    @Override
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @Override
    public Article show(Long id) {
        return (Article) articleRepository.findById(id).orElse(null);
    }

    /* CREATE
    */
    @Override
    public Article create(ArticleForm articleForm) {
        Article article = articleForm.toEntity();
        Article created = articleRepository.save(article);
        return created;
    }

    /* UPDATE
    */
    @Override
    public Article update(Long id, ArticleUpdateForm articleUpdateForm) {

        Article target = (Article) articleRepository.findById(id).orElse(null);

        if(target == null){
            log.info("수정 실패: 대상 엔티티가 없습니다. ID=" + articleUpdateForm.getId());
            return null;
        }

        target.patch(articleUpdateForm);
        Article updated = articleRepository.save(target);
        log.info("수정 완료: " + target.toString());

        return updated;
    }

    /* DELETE
    */
    @Override
    public Article delete(Long id) {

        Article target = (Article) articleRepository.findById(id).orElse(null);

        if(target == null){
            log.info("해당 Article이 없습니다. article, {}", target);
            return null;
        }

        articleRepository.delete(target);
        return target;

    }
}
