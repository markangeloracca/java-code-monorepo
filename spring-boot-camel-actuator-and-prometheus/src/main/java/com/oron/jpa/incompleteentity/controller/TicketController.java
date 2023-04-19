package com.oron.jpa.incompleteentity.controller;

import com.oron.jpa.incompleteentity.dto.Ticket;
import com.oron.jpa.incompleteentity.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Builder;

import java.util.List;

@RestController
@RequestMapping("ticket/api/v1")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<Ticket> postTicket() {
        Ticket ticket = Builder.build(Ticket.class)
                .with(t -> t.setTicketBuyer("Juan Dela Cruz")).get();

        return ResponseEntity.ok(ticketService.book(ticket));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Ticket>> getAllTicket() {
        return ResponseEntity.ok(ticketService.getAll());
    }
}
