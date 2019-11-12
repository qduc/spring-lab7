package com.lampart.duc.lab7.api.data;

import java.util.Optional;

public interface DataService<T> {

    Optional<T> findById(Long id);

    Iterable<T> findAll();

    T save(T entity);

    void deleteById(Long id);
}
