package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.entities.Article;
import com.emadesko.auchan.data.repositories.ArticleRepository;
import com.emadesko.auchan.data.repositories.CategorieRepository;
import com.emadesko.auchan.services.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl <Article> implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        super(articleRepository);
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Article update(Long id, Article article) {
        var art = this.articleRepository.findById(id).orElse(null);
        var cat = this.categorieRepository.findById(article.getCategorie().getId()).orElse(null);
        if (art != null && cat != null) {
            art.setName(article.getName());
            art.setCode(article.getCode());
            art.setPrix(article.getPrix());
            art.setQteStock(article.getQteStock());
            art.setCategorie(cat);
            return this.articleRepository.save(art);
        }
        return null;
    }
}
