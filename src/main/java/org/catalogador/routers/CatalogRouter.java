package org.catalogador.routers;

import org.catalogador.handlers.CatalogHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class CatalogRouter {

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(CatalogHandler handler) {
        return RouterFunctions
                .route(GET("/catalogs").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/catalog/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/catalog/create").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
