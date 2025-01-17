package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.entities.Categorie;
import com.emadesko.auchan.data.repositories.CategorieRepository;
import com.emadesko.auchan.services.CategorieService;
import org.springframework.stereotype.Service;

@Service
public class CategorieServiceImpl extends ServiceImpl <Categorie> implements CategorieService {

    private CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        super(categorieRepository);
    }

    @Override
    public Categorie update(Long id, Categorie categorie) {
        var cat = categorieRepository.findById(id).orElse(null);
        if (cat != null) {
            cat.setName(categorie.getName());
            cat.setCode(categorie.getCode());
            return this.categorieRepository.save(cat);
        }
        return null;
    }
}
