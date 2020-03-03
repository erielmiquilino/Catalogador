package org.catalogador.domains.models.omdb;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Search",
        "totalResults",
        "Response"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Search {

    @JsonProperty("Search")
    private List<SearchItem> searchItems = null;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;

}