package com.unifil.pontolimpo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifil.pontolimpo.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
