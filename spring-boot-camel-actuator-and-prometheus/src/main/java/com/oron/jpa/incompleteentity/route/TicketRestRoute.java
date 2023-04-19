package com.oron.jpa.incompleteentity.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class TicketRestRoute extends RouteBuilder {

    public static final String TICKET_URI = "/ticket/ping";

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .contextPath("/camel")
                .port("8080")
                .enableCORS(true)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Test REST API")
                .apiProperty("api.version", "v1")
                .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.auto);

        rest(TICKET_URI)
                .post()
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .to(TicketRoute.TICKET_ROUTE);

    }
}
