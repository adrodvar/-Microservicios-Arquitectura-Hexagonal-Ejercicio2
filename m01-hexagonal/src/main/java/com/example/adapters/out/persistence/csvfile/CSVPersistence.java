package com.example.adapters.out.persistence.csvfile;

import com.example.ports.out.StockReportOutPort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVPersistence implements StockReportOutPort {

    @Override
    public void saveReport(Map<String, String> report) {

        String csv = this.convertToCSV(report);
        String filename = this.getTimedFileName("stock_report_.csv");
        try {
            Files.write(Paths.get("reports/" + filename), csv.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String convertToCSV(Map<String, String> report) {
        StringBuilder stringBuilder = new StringBuilder();
//        String header = report.keySet().stream().collect(Collectors.joining(";"));
        String header = String.join(";", report.keySet());
        String row = String.join(";", report.values());
        stringBuilder.append(header);
        stringBuilder.append("\n");
        stringBuilder.append(row);

        return stringBuilder.toString();
    }

    private String getTimedFileName(String fileName){
        LocalDateTime now = LocalDateTime.now();
        String[] fileParts = fileName.split("\\.");

        String currentTime = String.format("%d_%d_%d_%d_%d_%d",
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(), // date
                now.getHour(), now.getMinute(), now.getSecond()); // time

        return fileParts[0] + "_" + currentTime + "." + fileParts[1];
    }
}
