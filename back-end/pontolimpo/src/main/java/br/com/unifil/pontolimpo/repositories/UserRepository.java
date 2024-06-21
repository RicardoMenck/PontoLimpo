package br.com.unifil.pontolimpo.repositories;

import br.com.unifil.pontolimpo.entites.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.unifil.pontolimpo.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Metodo para consultar o user através do email/login;
    UserDetails findByEmail(String email);

    User findByRole(UserRole userRole);

}
