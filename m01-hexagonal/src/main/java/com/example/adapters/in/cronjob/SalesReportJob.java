package com.example.adapters.in.cronjob;

import com.example.ports.in.StockReportInPort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*
Tareas programadas para ejecutarse con determinada frecuencia
para generar informes
 */
public class SalesReportJob {

    private final StockReportInPort stockReportInPort;

    public SalesReportJob(StockReportInPort stockReportInPort) {
        this.stockReportInPort = stockReportInPort;
    }

    @Scheduled(cron = "0 * * * * MON-FRI")
    public void generateStockReportDaily(){
        System.out.println("Ejecutando generateSalesReportDaily!!");
        this.stockReportInPort.generateStockReport();
    }

//    @Scheduled(cron = "0/5 * * * * *")
//    public void generateStockReportWeekly(){
//        System.out.println(LocalDateTime.now());
//    }
}
