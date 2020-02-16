package org.catalogador.handlers;

import lombok.AllArgsConstructor;
import org.catalogador.domains.Catalog;
import org.catalogador.services.interfaces.CatalogService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@AllArgsConstructor
public class CatalogHandler {

    private CatalogService catalogService;

    public Mono<ServerResponse> findAll (ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(catalogService.findAll(), Catalog.class);
    }

    public Mono<ServerResponse> findById (ServerRequest request) {
        var id = request.pathVariable("id");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(catalogService.findById(id), Catalog.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> save (ServerRequest request) {
        final Mono<Catalog> employeeMono = request.bodyToMono(Catalog.class);
        return ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(employeeMono.flatMap(catalogService::save), Catalog.class));
    }

}
