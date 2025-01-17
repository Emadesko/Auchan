package com.emadesko.auchan.data.repositories;


import com.emadesko.auchan.data.entities.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Long> {
}
