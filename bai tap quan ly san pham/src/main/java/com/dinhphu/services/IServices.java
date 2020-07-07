package com.dinhphu.services;

import java.util.List;

public interface IServices<T> {
    public List<T> findAll();

    public T findById(int id);

    public T save(T model);

    public void remove(int id);
}
