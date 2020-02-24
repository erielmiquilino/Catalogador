package org.catalogador.domains.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Title {

    private String title;

    private String year;

    private String poster;

    private String imdbId;


}
