package com.emadesko.auchan.data.repositories;

import com.emadesko.auchan.data.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
