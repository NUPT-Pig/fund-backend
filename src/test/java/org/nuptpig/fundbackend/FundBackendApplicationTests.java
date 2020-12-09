package org.nuptpig.fundbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nuptpig.fundbackend.dao.FundRepository;
import org.nuptpig.fundbackend.entity.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FundBackendApplicationTests {

    @Test
    void contextLoads() {
    }

}