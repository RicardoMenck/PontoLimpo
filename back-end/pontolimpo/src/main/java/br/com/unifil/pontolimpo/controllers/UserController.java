package br.com.unifil.pontolimpo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifil.pontolimpo.entites.User;
import br.com.unifil.pontolimpo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    //Injeção de um jeito diferente
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> list = userService.listUsers();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{idUser}")
    public ResponseEntity<User> findById(@PathVariable(value = "idUser") Long idUser) {
        var userO = userService.findUserByID(idUser);
        return ResponseEntity.ok().body(userO);
    }

    //POST
    // @PostMapping
    // public ResponseEntity<User> saveUser(@RequestBody User user) {
    //     var userO = userService.saveUser(user);
    //     URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idUser}").buildAndExpand(user.getIdUser()).toUri();
    //     return ResponseEntity.created(uri).body(userO);
    // }

    //PUT
    @PutMapping(value = "/{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "idUser") Long idUser, @RequestBody User user) {
        user = userService.updateUser(idUser, user);
        return ResponseEntity.ok().body(user);
    }

    //DELETE
    @DeleteMapping(value = "/{idUser}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "idUser") Long idUser) {
        userService.deleteUser(idUser);
            return ResponseEntity.noContent().build();
    }

}
