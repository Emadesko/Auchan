package com.emadesko.auchan.services.impl;

import com.emadesko.auchan.data.repositories.Repository;
import com.emadesko.auchan.services.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class ServiceImpl <T> implements Service <T> {

    private final Repository<T> repository;

    @Override
    public T getById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public T create(T t) {
        return  this.repository.save(t);
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    public abstract T update(Long id, T t) ;

    @Override
    public Boolean delete(Long id) {
        var data = this.repository.findById(id).orElse(null);
        if (data != null) {
            this.repository.delete(data);
            return true;
        }
        return false;
    }
}
