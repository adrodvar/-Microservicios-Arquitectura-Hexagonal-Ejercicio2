package com.example.core.usecases;

import com.example.core.domain.Product;
import com.example.ports.in.ProductReadInPort;
import com.example.ports.in.StockReportInPort;
import com.example.ports.out.StockReportOutPort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StockReportUseCase implements StockReportInPort {

    private ProductReadInPort productReader; // caso de uso para recuperar productos
    private StockReportOutPort stockReportOutPort; // adaptador de salida para generar reporte CSV

    public StockReportUseCase(ProductReadInPort productReader, StockReportOutPort stockReportOutPort) {
        this.productReader = productReader;
        this.stockReportOutPort = stockReportOutPort;
    }

    @Override
    public void generateStockReport() {
        List<Product> products = productReader.findAll();
        Integer totalStock = products.stream()
                .map(Product::getStock)
                .reduce(0, Integer::sum);

        Double totalPrice = products.stream()
                .map(p -> p.getStock() * p.getPrice())
                .reduce(0.0, Double::sum);

        Map<String, String> stockReport = new HashMap<>();
        stockReport.put("TOTAL STOCK", String.valueOf(totalStock));
        stockReport.put("TOTAL PRICE", String.valueOf(totalPrice));
        this.stockReportOutPort.saveReport(stockReport);

    }

}
