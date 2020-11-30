package org.nuptpig.fundbackend.service;

import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.vo.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface FundService {
    PageableFundResponse getFunds(Pageable pageable);
    Fund createFund(Fund fund);
    FundDetailResponse getFundByFundCode(String fundCode);
    Boolean bindUser(UserBindRequest userBindRequest);
}
