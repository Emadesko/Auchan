package com.emadesko.auchan.data.repositories;

import com.emadesko.auchan.data.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article ,Long> {
    List<Article> findArticlesByCategorie_Id(Long categorieId);
    Page<Article> findArticlesByCategorie_Id(Long categorieId, Pageable pageable);
}
