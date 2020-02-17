package org.catalogador.domains.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SearchItem {

    private String title;

    private String year;

    private String imdbID;

    private String type;

    private String poster;

}
