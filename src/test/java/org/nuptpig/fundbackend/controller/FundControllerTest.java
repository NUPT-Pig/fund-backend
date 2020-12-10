package org.nuptpig.fundbackend.controller;

import org.junit.jupiter.api.Test;
import org.nuptpig.fundbackend.FundBackendApplicationTests;
import org.nuptpig.fundbackend.entity.UserBinding;
import org.nuptpig.fundbackend.util.CommonResult;
import org.nuptpig.fundbackend.vo.FundDetailResponse;
import org.nuptpig.fundbackend.vo.PageableFundResponse;
import org.nuptpig.fundbackend.vo.UserBindRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.assertj.core.api.Assertions;


class FundControllerTest extends FundBackendApplicationTests {

    @Autowired
    private FundController fundController;

    @Test
    void getFunds() {
        Long INIT_FUND_TOTAL = 5L;
        ResponseEntity responseEntity = fundController.getFunds(20, 1);
        Assertions.assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
        PageableFundResponse pageableFundResponse = getVo(responseEntity);
        Assertions.assertThat(pageableFundResponse.getTotal().equals(INIT_FUND_TOTAL));
    }

    @Test
    @Transactional
    void createFund() {
    }

    @Test
    void getFundByFundCode() {
        String fundCode = "501010";
        ResponseEntity responseEntity = fundController.getFundByFundCode(fundCode);
        Assertions.assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
        FundDetailResponse fundDetailResponse = getVo(responseEntity);
        Assertions.assertThat(fundDetailResponse.getFundCode().equals(fundCode));
    }

    @Test
    void userBind() {
        String fundCode = "501010";
        String userName = "viewer";
        UserBindRequest userBindRequest = new UserBindRequest();
        userBindRequest.setFundCode(fundCode);
        userBindRequest.setUserName(userName);
        userBindRequest.setStatus(UserBinding.Status.FOLLOW);
        ResponseEntity responseEntity = fundController.userBind(userBindRequest);
        Assertions.assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
    }
}