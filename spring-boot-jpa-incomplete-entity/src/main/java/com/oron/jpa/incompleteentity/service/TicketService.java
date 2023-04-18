package com.oron.jpa.incompleteentity.service;

import com.oron.jpa.incompleteentity.dto.Ticket;
import com.oron.jpa.incompleteentity.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import util.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
@Slf4j
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    public Ticket book(Ticket ticket) {
        Random random = new Random();
        random.setSeed(100000);
        log.info("Booking ticket");
        Ticket toPost = Builder.build(Ticket.class)
                .with(t -> t.setTicketBuyer(ticket.getTicketBuyer()))
                .with(t -> t.setTicketId(UUID.randomUUID()))
                .with(t -> t.setTicketNumber(String.valueOf(random.nextInt())))
                .with(t -> t.setEventName("Black Pink Manila"))
                .with(t -> t.setPurchaseDate(LocalDateTime.now()))
                .get();

        return ticketRepository.save(toPost);
    }

    public List<Ticket> getAll() {

        List<Ticket> result = ticketRepository.findAll();

        log.info("Output: " + result.toString());

        return result;
    }
}
