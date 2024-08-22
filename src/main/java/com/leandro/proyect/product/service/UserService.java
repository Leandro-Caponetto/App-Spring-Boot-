package com.leandro.proyect.product.service;

import java.util.List;

import com.leandro.proyect.product.entity.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}
