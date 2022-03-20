package com.example.config;

import com.example.adapters.in.cronjob.SalesReportJob;
import com.example.ports.in.StockReportInPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // habilita el uso de tareas programadas @Scheduled
@Configuration
public class ScheduledConfig {


    @Bean
    public SalesReportJob salesReportJob(StockReportInPort stockReportInPort){
        return new SalesReportJob(stockReportInPort);
    }
}
