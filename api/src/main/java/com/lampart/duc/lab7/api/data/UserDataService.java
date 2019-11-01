package com.lampart.duc.lab7.api.data;

import java.util.Optional;

public interface UserDataService<T> {

    Optional<T> findById(Long id);

    Iterable<T> findAll();
}
