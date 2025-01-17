package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.entities.Article;
import com.emadesko.auchan.data.repositories.ArticleRepository;
import com.emadesko.auchan.services.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl <Article> implements ArticleService {

    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        super(articleRepository);
    }

    @Override
    public Article update(Long id, Article article) {
        var art = articleRepository.findById(id).orElse(null);
        if (art != null) {
            art.setName(article.getName());
            art.setCode(article.getCode());
            return this.articleRepository.save(art);
        }
        return null;
    }
}
