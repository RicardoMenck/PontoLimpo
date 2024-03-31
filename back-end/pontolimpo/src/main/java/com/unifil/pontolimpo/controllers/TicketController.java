package com.unifil.pontolimpo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifil.pontolimpo.entites.Ticket;
import com.unifil.pontolimpo.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    //Injeção
    private final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
//GET
    @GetMapping
    public ResponseEntity<List<Ticket>> listtickets() {
        List<Ticket> list = ticketService.listTickets();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable(value = "id") Long id) {
        var ticketO = ticketService.findTicketById(id);
        return ResponseEntity.ok().body(ticketO);
    }

    //POST
    @PostMapping
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
        var ticketO = ticketService.saveTicket(ticket);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(ticket.getId()).toUri();
        return ResponseEntity.created(uri).body(ticketO);
    }

    //PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Long id, @RequestBody Ticket ticket) {
        ticket = ticketService.updateTicket(id, ticket);
        return ResponseEntity.ok().body(ticket);
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable(value = "id") Long id) {
        ticketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
    }
}
