package org.catalogador.services.interfaces;

import org.catalogador.domains.entities.Catalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {

    Flux<Catalog> findAll();
    Mono<Catalog> findById(String id);
    Mono<Catalog> save(Catalog employee);

}
