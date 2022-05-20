package com.greenapex.CSV_Reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"com.greenapex.CSV_Reader"})
@EnableConfigurationProperties
public class CsvReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsvReaderApplication.class, args);
    }

}
