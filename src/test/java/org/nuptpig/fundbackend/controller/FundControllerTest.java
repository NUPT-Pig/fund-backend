package org.nuptpig.fundbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class FundControllerTest {
    @Autowired
    private FundController fundController;

    @Test
    void getFunds() {
        ResponseEntity responseEntity = fundController.getFunds(1, 2);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void createFund() {
    }

    @Test
    void getFundByFundCode() {

    }

    @Test
    void userBind() {
    }
}