package com.emadesko.auchan.web.controllers.impl;

import com.emadesko.auchan.services.CategorieService;
import com.emadesko.auchan.web.controllers.CategorieController;
import com.emadesko.auchan.web.dto.request.CategorieRequest;
import com.emadesko.auchan.web.dto.response.CategorieResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieControllerImpl implements CategorieController {
    private final CategorieService categorieService;

    public CategorieControllerImpl(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public ResponseEntity<List<CategorieResponse>> getAllCategories() {
        var categories = this.categorieService.findAll();
        List<CategorieResponse> categorieResponses = categories.stream().map(CategorieResponse::new).toList();
        return new ResponseEntity<>(categorieResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategorieResponse> getOneCategorie(Long id) {
        var categorie = this.categorieService.getById(id);
        CategorieResponse categorieResponse = null;
        if (categorie != null) {
            categorieResponse = new CategorieResponse(categorie);
        }
        return new ResponseEntity<>(categorieResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategorieResponse> createCategorie(CategorieRequest categorieRequest) {
        var categorie = categorieRequest.convert();
        categorie = this.categorieService.create(categorie);
        var categorieResponse = new CategorieResponse(categorie);
        return new ResponseEntity<>(categorieResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategorieResponse> updateCategorie(Long id, CategorieRequest categorieRequest) {
        var categorie = categorieRequest.convert();
        categorie = this.categorieService.update(id, categorie);
        CategorieResponse categorieResponse = null;
        if (categorie != null) {
            categorieResponse = new CategorieResponse(categorie);
        }
        return new ResponseEntity<>(categorieResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCategorie(Long id) {
        if (this.categorieService.delete(id)){
            return new ResponseEntity<>("Categorie supprimé avec succes", HttpStatus.OK);
        }
        return new ResponseEntity<>("Categorie non retrouvé", HttpStatus.OK);
    }
}
