package com.emadesko.auchan.data.repositories;

import com.emadesko.auchan.data.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
