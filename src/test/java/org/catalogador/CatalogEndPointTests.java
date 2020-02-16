package org.catalogador;

import org.catalogador.domains.Catalog;
import org.catalogador.domains.CatalogItem;
import org.catalogador.handlers.CatalogHandler;
import org.catalogador.routers.CatalogRouter;
import org.catalogador.services.interfaces.CatalogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CatalogRouter.class, CatalogHandler.class})
@WebFluxTest
public class CatalogEndPointTests {

	@Autowired
	private ApplicationContext context;

	@MockBean
	private CatalogService catalogService;

	private WebTestClient client;

	@Before
	public void setUp() {
		client = WebTestClient.bindToApplicationContext(context).build();
	}

	@Test
	public void givenCatalogId_whenFindById_thenCorrectCatalog() {

		List<CatalogItem> catalogItems = Arrays.asList(
				CatalogItem.builder()
						.title("CATALOG ITEM 1")
						.build(),
				CatalogItem.builder()
						.title("CATALOG ITEM 1")
						.build()
		);

		Catalog catalog = Catalog.builder()
				.id("1")
				.name("CATALOG")
				.catalogItems(catalogItems)
				.build();

		given(catalogService.findById("1")).willReturn(Mono.just(catalog));

		client.get()
				.uri("/catalog/1")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(Catalog.class)
				.isEqualTo(catalog);
	}

	@Test
	public void whenGetAllCatalogs_thenCorrectCatalogs() {
		List<CatalogItem> catalogItemsOne = Arrays.asList(
				CatalogItem.builder()
						.title("CATALOG ITEM 1")
						.build(),
				CatalogItem.builder()
						.title("CATALOG ITEM 2")
						.build()
		);

		List<CatalogItem> catalogItemsTwo = Arrays.asList(
				CatalogItem.builder()
						.title("CATALOG ITEM 3")
						.build(),
				CatalogItem.builder()
						.title("CATALOG ITEM 4")
						.build()
		);


		List<Catalog> catalogs = Arrays.asList(
				Catalog.builder().id("1").name("TEST 1").catalogItems(catalogItemsOne).build(),
				Catalog.builder().id("2").name("TEST 2").catalogItems(catalogItemsTwo).build()
		);

		Flux<Catalog> catalogFlux = Flux.fromIterable(catalogs);
		given(catalogService.findAll()).willReturn(catalogFlux);

		client.get()
				.uri("/catalogs")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBodyList(Catalog.class)
				.isEqualTo(catalogs);
	}

	@Test
	public void whenUpdateCatalog_thenCatalogUpdated() {
		List<CatalogItem> catalogItems = Arrays.asList(
				CatalogItem.builder()
						.title("CATALOG ITEM 1")
						.build(),
				CatalogItem.builder()
						.title("CATALOG ITEM 1")
						.build()
		);

		Catalog catalog = Catalog.builder()
				.id("1")
				.name("CATALOG")
				.catalogItems(catalogItems)
				.build();

		Mono<Catalog> catalogMono = Mono.just(catalog);

		when(catalogService.save(any())).thenReturn(catalogMono);

		client.post()
				.uri("/catalog/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(catalog), Catalog.class)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Catalog.class)
				.isEqualTo(catalog);
	}

}
