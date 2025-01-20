package com.emadesko.auchan.web.controllers.impl;

import com.emadesko.auchan.services.ArticleService;
import com.emadesko.auchan.web.controllers.ArticleController;
import com.emadesko.auchan.web.dto.request.ArticleRequest;
import com.emadesko.auchan.web.dto.response.ArticleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleControllerImpl implements ArticleController {
    private final ArticleService articleService;

    public ArticleControllerImpl(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity<Page<ArticleResponse>> getAllArticles(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        var articles = this.articleService.findAll(pageable);
        Page<ArticleResponse> articleResponses = articles.map(ArticleResponse::new);
        return new ResponseEntity<>(articleResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<ArticleResponse>> getArticlesByCategorie(Long categorieId,int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        var articles = this.articleService.getArticlesByCategorie_Id(categorieId,pageable);
        Page<ArticleResponse> articleResponses = articles.map(ArticleResponse::new);
        return new ResponseEntity<>(articleResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleResponse> getOneArticle(Long id) {
        var article = this.articleService.getById(id);
        ArticleResponse articleResponse = null;
        if (article != null) {
            articleResponse = new ArticleResponse(article);
        }
        return new ResponseEntity<>(articleResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleResponse> createArticle(ArticleRequest articleRequest) {
        var article = articleRequest.convert();
        article = this.articleService.create(article);
        var articleResponse = new ArticleResponse(article);
        return new ResponseEntity<>(articleResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleResponse> updateArticle(Long id, ArticleRequest articleRequest) {
        var article = articleRequest.convert();
        article = this.articleService.update(id, article);
        ArticleResponse articleResponse = null;
        if (article != null) {
            articleResponse = new ArticleResponse(article);
        }
        return new ResponseEntity<>(articleResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteArticle(Long id) {
        if (this.articleService.delete(id)){
            return new ResponseEntity<>("Article supprimé avec succes", HttpStatus.OK);
        }
        return new ResponseEntity<>("Article non retrouvé", HttpStatus.OK);
    }
}
