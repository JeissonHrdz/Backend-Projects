package org.personalblog.model.dao;

import org.personalblog.config.JsonUtil;
import org.personalblog.model.dto.ArticleDto;
import org.personalblog.model.entity.Article;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class ArticleDao {

    private static final String FILE_PATH = "personal-blog/src/main/resources/json/Articles.json";

    public List<Article> getArticles() {
        return JsonUtil.readJson(FILE_PATH);
    }

    public void saveArticle(Article article) {
        List<Article> articles = getArticles();
        articles.add(article);
        JsonUtil.saveJson(FILE_PATH, articles);
    }


}


