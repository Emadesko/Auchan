package com.emadesko.auchan.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service <T> {
    T getById(Long id);
    T create(T t);
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    T update(Long id, T t);
    Boolean delete(Long id);
}
