package com.example.adapters.out.persistence.csvfile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CSVPersistenceTest {

    // SUT
    private CSVPersistence csvPersistenceAdapter = new CSVPersistence();

    @Test
    void saveReport() {

        Map<String, String> stockReport = new HashMap<>();
        stockReport.put("TOTAL STOCK", "876");
        stockReport.put("TOTAL PRICE", "25436.77");

        File[] listFilesBefore = new File("reports").listFiles();
        assertNotNull(listFilesBefore);
        assertEquals(0, listFilesBefore.length);

        csvPersistenceAdapter.saveReport(stockReport);

        File[] listFilesAfter = new File("reports").listFiles();
        assertNotNull(listFilesAfter);
        assertEquals(1, listFilesAfter.length);

    }


}