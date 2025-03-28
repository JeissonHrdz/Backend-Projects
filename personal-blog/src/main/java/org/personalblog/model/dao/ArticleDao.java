package org.personalblog.model.dao;

import org.personalblog.config.JsonUtil;
import org.personalblog.model.dto.ArticleDto;
import org.personalblog.model.entity.Article;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class ArticleDao {

    private static final String FILE_PATH = "Articles.json";

    public List<Article> getArticles() {
        return JsonUtil.readJson(FILE_PATH);
    }

    public Article getArticle(String id) {
        List<Article> articles = getArticles();
        for (Article article : articles) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    public void saveArticle(Article article) {
        List<Article> articles = getArticles();
        articles.add(article);
        JsonUtil.saveJson(FILE_PATH, articles);
    }




}


