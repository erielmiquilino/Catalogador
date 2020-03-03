package org.catalogador.services;

import org.catalogador.domains.models.omdb.Search;
import org.catalogador.domains.models.Title;
import org.catalogador.services.interfaces.MetadataService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@Service
public class MetadataServiceImpl implements MetadataService {

    @Value("${omdbapi.url}")
    private String url;

    @Value("${omdbapi.apikey}")
    private String apiKay;

    public Flux<Title> searchMetadata(String title) {
        ModelMapper modelMapper = new ModelMapper();

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("apikey", apiKay)
                .queryParam("s", title)
                .queryParam("type", "movie")
                .queryParam("page", "1");

        var searchList = restTemplate.getForObject(builder.toUriString(), Search.class);

        if (searchList == null || searchList.getSearchItems() == null)
            return Flux.empty();

        List<Title> titles = modelMapper.map(searchList.getSearchItems(), new TypeToken<List<Title>>(){}.getType());

        return Flux.fromIterable(titles);
    }

}
