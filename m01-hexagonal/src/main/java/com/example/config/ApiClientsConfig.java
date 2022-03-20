package com.example.config;

import com.example.adapters.out.api.fakestore.FakeStoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
Clase para configurar clientes a APIs externas de los adaptadores de salida
 */
@Configuration
public class ApiClientsConfig {
    @Bean
    public RestTemplate restTemplate(){
//        return new RestTemplateBuilder().build(); // para customizar
        return new RestTemplate();
    }

    @Bean
    public FakeStoreClient fakeStoreClient(RestTemplate client){
        return new FakeStoreClient(client);
    }
}
