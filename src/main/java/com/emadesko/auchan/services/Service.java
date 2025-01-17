package com.emadesko.auchan.services;

import java.util.List;

public interface Service <T> {
    T getById(Long id);
    T create(T t);
    List<T> findAll();
    T update(Long id, T t);
    Boolean delete(Long id);
}
