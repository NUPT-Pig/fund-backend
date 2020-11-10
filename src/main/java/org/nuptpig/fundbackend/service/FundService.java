package org.nuptpig.fundbackend.service;

import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.vo.FundDetailResponse;
import org.nuptpig.fundbackend.vo.FundResponse;

import java.util.List;

public interface FundService {
    List<FundResponse> getFunds();
    Fund createFund(Fund fund);
    FundDetailResponse getFundByFundCode(String fundCode);
}
