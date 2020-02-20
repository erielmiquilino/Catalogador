package org.catalogador.services.interfaces;

import org.catalogador.domains.models.Title;
import reactor.core.publisher.Flux;

public interface MetadataService {

    Flux<Title> searchMetadata(String title);

}
