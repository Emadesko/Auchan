package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.services.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class ServiceImpl <T> implements Service <T> {

    private final JpaRepository<T, Long> baseRepository;

    protected ServiceImpl(JpaRepository<T, Long> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public T getById(Long id) {
        return this.baseRepository.findById(id).orElse(null);
    }

    @Override
    public T create(T t) {
        return  this.baseRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return this.baseRepository.findAll();
    }

    @Override
    public abstract T update(Long id, T t) ;

    @Override
    public Boolean delete(Long id) {
        var data = this.baseRepository.findById(id).orElse(null);
        if (data != null) {
            this.baseRepository.delete(data);
            return true;
        }
        return false;
    }
}
