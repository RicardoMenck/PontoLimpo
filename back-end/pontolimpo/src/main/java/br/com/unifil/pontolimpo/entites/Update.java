package br.com.unifil.pontolimpo.entites;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class Update {

    private String description;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
