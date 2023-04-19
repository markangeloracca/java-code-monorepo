package com.oron.jpa.incompleteentity.repository;

import com.oron.jpa.incompleteentity.dto.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
