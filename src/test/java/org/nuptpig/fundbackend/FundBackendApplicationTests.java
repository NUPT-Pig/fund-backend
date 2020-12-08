package org.nuptpig.fundbackend;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuptpig.fundbackend.dao.FundRepository;
import org.nuptpig.fundbackend.entity.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class FundBackendApplicationTests {
    @Autowired
    private FundRepository fundRepository;

    @Before
    public void init(){
        System.out.println("before test");
        Fund fund = new Fund();
        fund.setFundName("test");
        fund.setFundCode("11111");
        fundRepository.save(fund);
    }

    @Test
    public void contextLoads() {
        System.out.println(fundRepository.findAll());
    }



}
