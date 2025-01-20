package com.emadesko.auchan.web.controllers;

import com.emadesko.auchan.web.dto.request.CategorieRequest;
import com.emadesko.auchan.web.dto.response.CategorieResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")
public interface CategorieController {
    @GetMapping("")
    ResponseEntity<Page<CategorieResponse>> getAllCategories(
            @RequestParam( defaultValue = "1") int page,
            @RequestParam( defaultValue = "5") int size
    );

    @GetMapping("{id}")
    ResponseEntity<CategorieResponse> getOneCategorie(@PathVariable Long id);

    @PostMapping("")
    ResponseEntity<CategorieResponse> createCategorie(@RequestBody CategorieRequest categorieRequest);

    @PutMapping("{id}")
    ResponseEntity<CategorieResponse> updateCategorie(@PathVariable Long id, @RequestBody CategorieRequest categorieRequest);

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteCategorie(@PathVariable Long id);
}
