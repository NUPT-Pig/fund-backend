package org.nuptpig.fundbackend.service.serviceimpl;

import org.nuptpig.fundbackend.dao.FundRepository;
import org.nuptpig.fundbackend.dao.StockRatingRepository;
import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.entity.StockRating;
import org.nuptpig.fundbackend.service.FundService;
import org.nuptpig.fundbackend.util.MapperHelper;
import org.nuptpig.fundbackend.vo.FundDetailResponse;
import org.nuptpig.fundbackend.vo.FundResponse;
import org.nuptpig.fundbackend.vo.StockInFundResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundServiceImpl implements FundService {
    private final FundRepository fundRepository;

    public FundServiceImpl(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    @Override
    public List<FundResponse> getFunds() {
        List<Fund> funds = fundRepository.findAll();
        return MapperHelper.SourcesToDestinations(funds, FundResponse.class);
    }

    @Override
    public Fund createFund(Fund fund) {
        return fundRepository.save(fund);
    }

    @Override
    public FundDetailResponse getFundByFundCode(String fundCode) {
        Fund fund = fundRepository.getFundByFundCode(fundCode);
        return MapperHelper.SourceToDestination(fund, FundDetailResponse.class);
    }
}
