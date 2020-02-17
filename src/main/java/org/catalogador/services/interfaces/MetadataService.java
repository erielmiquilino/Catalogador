package org.catalogador.services.interfaces;

import org.catalogador.domains.models.Search;
import reactor.core.publisher.Mono;

public interface MetadataService {

    Mono<Search> searchMetadata(String title);

}
