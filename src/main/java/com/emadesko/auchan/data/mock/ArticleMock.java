package com.emadesko.auchan.data.mock;

import com.emadesko.auchan.data.entities.Article;
import com.emadesko.auchan.data.entities.Categorie;
import com.emadesko.auchan.data.repositories.ArticleRepository;
import com.emadesko.auchan.data.repositories.CategorieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@Order(2)
public class ArticleMock implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    public ArticleMock(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Article> articles = new ArrayList<>();
        for (Categorie categorie: categorieRepository.findAll()) {
            for (int i = 1; i <= 5; i++) {
                var art  = new Article();
                art.setName("Article " + i + " de " + categorie.getName());
                art.setCode("ART_" + i + "_CODE" + " de " + categorie.getName());
                art.setPrix((float)15000);
                art.setQteStock(15);
                art.setCategorie(categorie);
                articles.add(art);
            }
        }
        articleRepository.saveAllAndFlush(articles);
    }
}
