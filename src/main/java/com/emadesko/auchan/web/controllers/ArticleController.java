package com.emadesko.auchan.web.controllers;

import com.emadesko.auchan.web.dto.request.ArticleRequest;
import com.emadesko.auchan.web.dto.response.ArticleResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/articles")
public interface ArticleController {
    @GetMapping("")
    ResponseEntity<Page<ArticleResponse>> getAllArticles(
            @RequestParam( defaultValue = "1") int page,
            @RequestParam( defaultValue = "5") int size
    );

    @GetMapping("/categorie/{categorieId}")
    ResponseEntity<Page<ArticleResponse>> getArticlesByCategorie(@PathVariable Long categorieId,
            @RequestParam( defaultValue = "1") int page,
            @RequestParam( defaultValue = "5") int size);

    @GetMapping("{id}")
    ResponseEntity<ArticleResponse> getOneArticle(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<ArticleResponse> createArticle(@RequestBody ArticleRequest articleRequest);

    @PutMapping("{id}")
    ResponseEntity<ArticleResponse> updateArticle(@PathVariable Long id, @RequestBody ArticleRequest articleRequest);

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteArticle(@PathVariable Long id);
}
