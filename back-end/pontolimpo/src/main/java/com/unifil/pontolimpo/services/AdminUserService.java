package com.unifil.pontolimpo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unifil.pontolimpo.entites.User;
import com.unifil.pontolimpo.entites.enums.UserRole;
import com.unifil.pontolimpo.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AdminUserService {
    private final UserRepository userRepository;

     public AdminUserService(UserRepository userRepository) {
         this.userRepository = userRepository;
     }


     @PostConstruct
     public void createAdminAccount(){
         User adminAccount = userRepository.findByRole(UserRole.ADMIN);
         if(adminAccount == null) {
             var admin = new User();
             admin.setEmail("admin@pontolimpo.com");
             admin.setUserName("admin");
             admin.setRole(UserRole.ADMIN);
             admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
             userRepository.save(admin);
         }
     }
}
