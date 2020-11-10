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
    private final StockRatingRepository stockRatingRepository;

    public FundServiceImpl(FundRepository fundRepository, StockRatingRepository stockRatingRepository) {
        this.fundRepository = fundRepository;
        this.stockRatingRepository = stockRatingRepository;
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
        List<StockRating> stockRatings = stockRatingRepository.findAllByFundFundCode(fundCode);
        List<StockInFundResponse> stockInFundResponses = new ArrayList<>();
        for(StockRating stockRating : stockRatings){
            stockInFundResponses.add(new StockInFundResponse(stockRating.getStock().getStockCode(),
                    stockRating.getStock().getStockName(), stockRating.getRate()));
        }
        return new FundDetailResponse(fundCode, fund.getFundName(), stockInFundResponses);
    }
}
