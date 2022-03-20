package com.example.adapters.out.api.fakestore;

public record FakeProductDTO(Long id, String title, Double price, String description,
                             String category, String image,
                             RatinDTO rating) {
}
