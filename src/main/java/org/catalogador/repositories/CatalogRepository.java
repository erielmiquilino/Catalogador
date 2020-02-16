package org.catalogador.repositories;

import org.catalogador.domains.Catalog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CatalogRepository extends ReactiveMongoRepository<Catalog, String> {

}
