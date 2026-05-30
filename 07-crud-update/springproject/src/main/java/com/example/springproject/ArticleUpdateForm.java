package com.example.springproject;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Slf4j
public class ArticleUpdateForm {

    private Long id;   // <input> 캐그로 id를 추가했기 때문에 DTO에서 id 추가
    private String title;
    private String content;
    public Article toEntity() {
        return new Article(id, title, content);
    }
    public void logInfo() {
        log.info("title: {}, content: {}", title, content );
    }

}
