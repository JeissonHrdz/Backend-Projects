package org.personalblog.services;

import org.personalblog.model.dao.ArticleDao;
import org.personalblog.model.dto.ArticleDto;
import org.personalblog.model.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {


    private final ArticleDao articleDao = new ArticleDao();

    public List<Article> getAllArticles() {
        return articleDao.getArticles();
    }

    public void addArticle(ArticleDto articleDto) {
        Article article = Article.builder()
                .id(articleDto.getId())
                .title(articleDto.getTitle())
                .date(articleDto.getDate())
                .content(articleDto.getContent())
                .build();
        articleDao.saveArticle(article);
    }
}
