package org.catalogador.services;

import org.catalogador.domains.models.Result;
import org.catalogador.domains.models.Title;
import org.catalogador.mappers.TitleMapper;
import org.catalogador.services.interfaces.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
public class MetadataServiceImpl implements MetadataService {

    @Value("${omdbapi.url}")
    private String url;

    @Value("${omdbapi.apikey}")
    private String apiKay;

    private final TitleMapper titleMapper;

    @Autowired
    public MetadataServiceImpl(TitleMapper titleMapper) {
        this.titleMapper = titleMapper;
    }

    public Flux<Title> searchMetadata(String title) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("apikey", apiKay)
                .queryParam("s", title)
                .queryParam("type", "movie")
                .queryParam("page", "1");

        var results = restTemplate.getForObject(builder.toUriString(), Result.class);

        var titles = titleMapper.map.searchesToTitles(Objects.requireNonNull(results).getSearch());

        return Flux.fromIterable(titles);
    }

}
