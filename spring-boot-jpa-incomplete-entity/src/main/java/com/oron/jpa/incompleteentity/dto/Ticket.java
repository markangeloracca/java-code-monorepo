package com.oron.jpa.incompleteentity.dto;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = Ticket.TABLE_NAME, schema = "dbo")
public class Ticket {

    public static final String TABLE_NAME = "Ticket";

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID ticketId;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "ticket_buyer")
    private String ticketBuyer;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

}
