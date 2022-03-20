package com.example.adapters.out.api.fakestore;

import com.example.core.domain.Product;
import com.example.ports.out.FakeProductsOutPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Clase cliente para la API Fake Store
https://fakestoreapi.com/
 */
public class FakeStoreClient implements FakeProductsOutPort {

    String urlProducts = "https://fakestoreapi.com/products";
    private final RestTemplate springClient;

    public FakeStoreClient(RestTemplate springClient) {
        this.springClient = springClient;
    }

    @Override
    public List<Product> fetchAll() {
        ResponseEntity<FakeProductDTO[]> response = springClient.getForEntity(urlProducts, FakeProductDTO[].class);
        if(response.getStatusCodeValue() != 200 || response.getBody() == null){
            System.out.println("Error de comunicación");
            return new ArrayList<>();
        }
        FakeProductDTO[] productsArray = response.getBody();

        /* IMPORTANTE: no confundir con Stream.of Ver diferencia:
            Arrays.stream: Stream<FakeProductDTO>
            Stream.of: Stream<FakeProductDTO[]>
         */
        return Arrays.stream(productsArray).map(FakeProductMapper::of).toList();
    }
}
