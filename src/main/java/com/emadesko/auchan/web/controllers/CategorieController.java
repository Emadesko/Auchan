package com.emadesko.auchan.web.controllers;

import com.emadesko.auchan.web.dto.request.CategorieRequest;
import com.emadesko.auchan.web.dto.response.CategorieResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categorie")
public interface CategorieController {
    @GetMapping("/list")
    ResponseEntity<List<CategorieResponse>> getAllCategories();

    @GetMapping("/one/{id}")
    ResponseEntity<CategorieResponse> getOneCategorie(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<CategorieResponse> createCategorie(@RequestBody CategorieRequest categorieRequest);

    @PostMapping("/update/{id}")
    ResponseEntity<CategorieResponse> updateCategorie(@PathVariable Long id, @RequestBody CategorieRequest categorieRequest);

    @PostMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteCategorie(@PathVariable Long id);
}
