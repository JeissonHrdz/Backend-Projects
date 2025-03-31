package org.personalblog.services;

import org.personalblog.model.dao.ArticleDao;
import org.personalblog.model.dto.ArticleDto;
import org.personalblog.model.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArticleService {


    private final ArticleDao articleDao = new ArticleDao();

    public List<Article> getAllArticles() {
        return articleDao.getArticles();
    }

    public Article getArticleById(String id) {
        return articleDao.getArticle(id);
    }

    public void addArticle(ArticleDto articleDto) {
        UUID id = UUID.randomUUID();
        Article article = Article.builder()
                .id(id.toString())
                .title(articleDto.getTitle())
                .date(articleDto.getDate())
                .content(articleDto.getContent())
                .build();
        articleDao.saveArticle(article);
    }

    public void updateArticle(ArticleDto articleDto, String id) {
        Article article = articleDao.getArticle(articleDto.getId());
        article.setTitle(articleDto.getTitle());
        article.setDate(articleDto.getDate());
        article.setContent(articleDto.getContent());
        articleDao.updateArticle(article);
    }

    public void deleteArticle(String id) {
        articleDao.deleteArticle(id);
    }

    public boolean login(String username, String password) {
       return articleDao.login(username, password);
    }
}
