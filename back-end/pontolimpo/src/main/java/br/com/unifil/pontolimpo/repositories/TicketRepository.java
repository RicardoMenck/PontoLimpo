package br.com.unifil.pontolimpo.repositories;

import br.com.unifil.pontolimpo.entites.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
 
}
