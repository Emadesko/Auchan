package com.emadesko.auchan.data.repositories;

import com.emadesko.auchan.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
