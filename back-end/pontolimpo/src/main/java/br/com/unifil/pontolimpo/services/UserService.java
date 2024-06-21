package br.com.unifil.pontolimpo.services;

import java.util.List;
import java.util.Optional;

import br.com.unifil.pontolimpo.services.exceptions.DatabaseException;
import br.com.unifil.pontolimpo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.unifil.pontolimpo.entites.User;
import br.com.unifil.pontolimpo.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //GET
    public User findUserByID(Long idUser) {
        Optional<User> userO = userRepository.findById(idUser);
        return userO.get();
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    //POST - Junto ao Login;
    // public User saveUser(User user) {
    //     return userRepostory.save(user);
    // }

    //PUT
    public User updateUser(Long idUser, User user) {
        try {
            User entity = userRepository.getReferenceById(idUser);
            updateDataUser(entity, user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(idUser);
        }
    }

    private void updateDataUser(User entity, User user) {
        entity.setEmail(entity.getEmail());
        entity.setUserName(entity.getUserName());
    }

    //DELETE
    public void deleteUser(Long idUser) {  
    try {
        userRepository.deleteById(idUser);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(idUser);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
