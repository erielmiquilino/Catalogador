package org.catalogador.services;

import lombok.AllArgsConstructor;
import org.catalogador.domains.entities.Catalog;
import org.catalogador.repositories.CatalogRepository;
import org.catalogador.services.interfaces.CatalogService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CatalogServicesImpl implements CatalogService {

    private CatalogRepository catalogRepository;

    public Flux<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    public Mono<Catalog> findById(String id) {
        return catalogRepository.findById(id);
    }

    public Mono<Catalog> save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }
}
