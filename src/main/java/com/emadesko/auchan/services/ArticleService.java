package com.emadesko.auchan.services;

import com.emadesko.auchan.data.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService extends Service<Article> {
    List<Article> getArticlesByCategorie_Id(Long categorieId);
    Page<Article> getArticlesByCategorie_Id(Long categorieId, Pageable pageable);
}
