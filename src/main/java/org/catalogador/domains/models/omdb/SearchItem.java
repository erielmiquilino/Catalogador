package org.catalogador.domains.models.omdb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Title",
        "Year",
        "imdbID",
        "Type",
        "Poster"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SearchItem {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Poster")
    private String poster;
}
