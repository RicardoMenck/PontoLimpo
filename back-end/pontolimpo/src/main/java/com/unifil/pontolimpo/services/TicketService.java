package com.unifil.pontolimpo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.unifil.pontolimpo.entites.Ticket;
import com.unifil.pontolimpo.repositories.TicketRepository;
import com.unifil.pontolimpo.services.exceptions.DatabaseException;
import com.unifil.pontolimpo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    //GET
    public Ticket findTicketById(Long id) {
        Optional<Ticket> ticketO = ticketRepository.findById(id);
        return ticketO.get();
    }

    public List<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

    //POST
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


    //PUT
    public Ticket updateTicket(Long id, Ticket ticket) {
        try{
            Ticket entity = ticketRepository.getReferenceById(id);
            updateDataTicket(entity, ticket);
            return ticketRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDataTicket(Ticket entity, Ticket ticket) {
        entity.setTitulo(ticket.getTitulo());
        entity.setDescrição(ticket.getDescrição());
        entity.setLocalização(ticket.getLocalização());
        entity.setStatus(ticket.getStatus());
        entity.setAtivo(ticket.isAtivo());
    }

    //DELETE
    public void deleteTicket(Long id) {
        try {
            ticketRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }
    
}
