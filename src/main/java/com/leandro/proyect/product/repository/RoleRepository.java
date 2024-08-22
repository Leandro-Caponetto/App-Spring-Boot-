package com.leandro.proyect.product.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.leandro.proyect.product.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
