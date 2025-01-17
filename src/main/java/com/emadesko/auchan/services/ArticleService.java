package com.emadesko.auchan.services;

import com.emadesko.auchan.data.entities.Article;

import java.util.List;

public interface ArticleService extends Service<Article> {
    List<Article> getArticlesByCategorie_Id(Long categorieId);
}
