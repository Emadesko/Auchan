package com.emadesko.auchan.data.repositories;

import com.emadesko.auchan.data.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article ,Long> {
}
