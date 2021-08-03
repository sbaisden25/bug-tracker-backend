package com.example.bugtracker.ticket;

import com.example.bugtracker.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket addTicket(Ticket ticket) {
        // Logic
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return ticketRepository.findTicketById(id)
                .orElseThrow(() ->
                        new TicketNotFoundException("Ticket by id " + id + " was not found"));
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteTicketById(id);
    }
}
