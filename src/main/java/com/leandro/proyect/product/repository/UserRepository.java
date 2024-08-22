package com.leandro.proyect.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.leandro.proyect.product.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);
}
