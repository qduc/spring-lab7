package com.lampart.duc.lab7.data.repository;

import com.lampart.duc.lab7.data.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Long> {

    @Override
    Optional<Users> findById(Long aLong);

    @Override
    Iterable<Users> findAll();
}
