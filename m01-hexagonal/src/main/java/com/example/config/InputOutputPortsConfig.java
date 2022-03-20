package com.example.config;

import com.example.adapters.out.persistence.csvfile.CSVPersistence;
import com.example.adapters.out.persistence.sqldatabase.springdatajpa.ProductDAO;
import com.example.adapters.out.persistence.sqldatabase.springdatajpa.ProductRepository;
import com.example.core.usecases.ProductReadUseCase;
import com.example.core.usecases.ProductWriteUseCase;
import com.example.core.usecases.StockReportUseCase;
import com.example.ports.in.ProductReadInPort;
import com.example.ports.in.ProductWriteInPort;
import com.example.ports.in.StockReportInPort;
import com.example.ports.out.ProductReadOutPort;
import com.example.ports.out.ProductWriteOutPort;
import com.example.ports.out.StockReportOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase para configurar la inyección de beans con Spring
 * Configura los beans para las interfaces de los puertos de entrada y salida
 */
@Configuration
public class InputOutputPortsConfig {


    // Adaptador de persistencia
    @Bean
    public ProductDAO productDAO(ProductRepository productRepository){
        return new ProductDAO(productRepository);
    }

    @Bean
    public ProductReadInPort productReadUseCase(ProductReadOutPort readOutPort){
        return new ProductReadUseCase(readOutPort);
    }

    @Bean
    public ProductWriteInPort productWriteUseCase(ProductWriteOutPort writeOutPort){
        return new ProductWriteUseCase(writeOutPort);
    }

    // 1. Puerto de salida: adaptador CSVPersistence
    @Bean
    public StockReportOutPort stockReportOutPort(){
        return new CSVPersistence();
    }

    // 2. Puerto de entrada: Caso de uso
    @Bean
    public StockReportInPort stockReportInPort(ProductReadInPort productReadUseCase,
                                                StockReportOutPort stockReportOutPort){
        return new StockReportUseCase(productReadUseCase, stockReportOutPort);
    }



}
