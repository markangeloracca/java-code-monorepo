package com.oron.jpa.incompleteentity.route;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class TicketRoute extends RouteBuilder {

    public static final String TICKET_ROUTE = "direct://TicketRoute";

    @Override
    public void configure() throws Exception {

        from(TICKET_ROUTE)
                .routeId(TICKET_ROUTE)
                .log("Hello Ticket Route");

    }
}
