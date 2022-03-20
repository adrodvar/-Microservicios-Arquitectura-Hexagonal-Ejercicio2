package com.example.adapters.out.api.fakestore;

import com.example.core.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeStoreClientTest {

    @Autowired
    private FakeStoreClient client;

    @Test
    void fetchAll() {
        List<Product> products = this.client.fetchAll();
        assertNotNull(products);
        assertEquals(20, products.size());
    }
}