package org.nuptpig.fundbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nuptpig.fundbackend.dao.FundRepository;
import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FundBackendApplicationTests {

    protected <T> T getVo(ResponseEntity responseEntity){
        CommonResult commonResult = (CommonResult) responseEntity.getBody();
        return (T) commonResult.getData();
    }

    @Test
    void contextLoads() {
    }

}