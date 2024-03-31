package com.unifil.pontolimpo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifil.pontolimpo.entites.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
 
}
