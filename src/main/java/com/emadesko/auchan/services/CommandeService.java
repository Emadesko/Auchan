package com.emadesko.auchan.services;

import com.emadesko.auchan.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommandeService extends Service<Commande> {
    Page<Commande> getCommandeByClient_Id(Long clientId, Pageable pageable);
}
