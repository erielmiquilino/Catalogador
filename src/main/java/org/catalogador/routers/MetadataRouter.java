package org.catalogador.routers;

import org.catalogador.handlers.MetadataHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class MetadataRouter {

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(MetadataHandler handler) {
        return RouterFunctions
                .route(GET("/metadata/search/{title}").and(accept(MediaType.APPLICATION_JSON)), handler::findByTitle);
    }

}
