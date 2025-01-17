package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.entities.Categorie;
import com.emadesko.auchan.data.repositories.CategorieRepository;
import com.emadesko.auchan.services.CategorieService;
import org.springframework.stereotype.Service;

@Service
public class CategorieServiceImpl extends ServiceImpl <Categorie> implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository, CategorieRepository categorieRepository1) {
        super(categorieRepository);
        this.categorieRepository = categorieRepository1;
    }

    @Override
    public Categorie update(Long id, Categorie categorie) {
        var cat = this.categorieRepository.findById(id).orElse(null);
        if (cat != null) {
            cat.setName(categorie.getName());
            cat.setCode(categorie.getCode());
            return this.categorieRepository.save(cat);
        }
        return null;
    }
}
