package org.nuptpig.fundbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FundBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundBackendApplication.class, args);
    }

}
