package org.catalogador.domains.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.catalogador.domains.base.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Catalog extends Entity {

    private String name;

    private List<CatalogItem> catalogItems;

}