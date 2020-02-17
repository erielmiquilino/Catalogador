package org.catalogador.services;

import lombok.AllArgsConstructor;
import org.catalogador.domains.models.Search;
import org.catalogador.services.interfaces.MetadataService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MetadataServiceImpl implements MetadataService {

    public Mono<Search> searchMetadata(String title) {
        return null;
    }

}
