package org.catalogador.domains.entities;

import lombok.*;
import org.catalogador.domains.enums.ItemType;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class CatalogItem {

    private String title;

    private String released;

    private String runtime;

    private String genre;

    private String director;

    private String writer;

    private String actors;

    private String plot;

    private String poster;

    private BigDecimal imdbRating;

    private BigDecimal imdbVotes;

    private ItemType type;

    private String production;

}
