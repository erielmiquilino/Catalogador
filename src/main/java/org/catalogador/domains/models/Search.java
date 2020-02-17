package org.catalogador.domains.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Search {

    public List<SearchItem> searchItems;

    public String totalResults;

    public String response;

}
