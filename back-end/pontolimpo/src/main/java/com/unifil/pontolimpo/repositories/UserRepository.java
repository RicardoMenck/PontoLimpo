package com.unifil.pontolimpo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.unifil.pontolimpo.entites.User;
import com.unifil.pontolimpo.entites.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Metodo para consultar o user através do email/login;
    UserDetails findByEmail(String email);

    User findByRole(UserRole userRole);

}
