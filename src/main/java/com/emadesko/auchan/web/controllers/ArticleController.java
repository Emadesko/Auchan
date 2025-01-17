package com.emadesko.auchan.web.controllers;

import com.emadesko.auchan.web.dto.request.ArticleRequest;
import com.emadesko.auchan.web.dto.response.ArticleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/article")
public interface ArticleController {
    @GetMapping("/list")
    ResponseEntity<List<ArticleResponse>> getAllArticles();

    @GetMapping("/categorie/{categorieId}")
    ResponseEntity<List<ArticleResponse>> getArticlesByCategorie(@PathVariable Long categorieId);

    @GetMapping("/one/{id}")
    ResponseEntity<ArticleResponse> getOneArticle(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<ArticleResponse> createArticle(@RequestBody ArticleRequest articleRequest);

    @PostMapping("/update/{id}")
    ResponseEntity<ArticleResponse> updateArticle(@PathVariable Long id, @RequestBody ArticleRequest articleRequest);

    @PostMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteArticle(@PathVariable Long id);
}
