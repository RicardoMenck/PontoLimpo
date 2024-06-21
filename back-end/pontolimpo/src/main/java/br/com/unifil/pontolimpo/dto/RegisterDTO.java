package br.com.unifil.pontolimpo.dto;

import br.com.unifil.pontolimpo.entites.enums.UserRole;

public record RegisterDTO(String userName, String email, String password, UserRole role) {
}
