package org.catalogador.domains.models;

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
public class Result {

    @JsonProperty("Search")
    private List<Search> search = null;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;

}