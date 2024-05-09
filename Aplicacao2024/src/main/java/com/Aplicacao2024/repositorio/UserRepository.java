package com.aplicacao2024.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao2024.entidades.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}