package com.emadesko.auchan.data.mock;

import com.emadesko.auchan.data.entities.Categorie;
import com.emadesko.auchan.data.repositories.CategorieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class CategorieMock implements CommandLineRunner {

    private final CategorieRepository categorieRepository;

    public CategorieMock(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categories = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            var cat  = new Categorie();
            cat.setName("Catégorie " + i);
            cat.setCode("CAT_" + i + "_CODE");
            categories.add(cat);
        }
        categorieRepository.saveAllAndFlush(categories);
    }
}
