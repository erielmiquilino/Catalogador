package org.catalogador.handlers;

import lombok.AllArgsConstructor;
import org.catalogador.domains.Catalog;
import org.catalogador.services.interfaces.MetadataService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;

@Component
@AllArgsConstructor
public class MetadataHandler {

    private MetadataService metadataService;

    public Mono<ServerResponse> findByTitle (ServerRequest request) {
        var title = request.pathVariable("title");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(metadataService.searchMetadata(title), Catalog.class)
                .switchIfEmpty(notFound().build());
    }

}
