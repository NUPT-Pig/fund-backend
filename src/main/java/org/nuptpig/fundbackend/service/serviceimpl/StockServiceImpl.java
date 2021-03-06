package org.nuptpig.fundbackend.service.serviceimpl;

import org.nuptpig.fundbackend.dao.StockRatingRepository;
import org.nuptpig.fundbackend.entity.StockRating;
import org.nuptpig.fundbackend.service.StockService;
import org.nuptpig.fundbackend.vo.FundResponse;
import org.nuptpig.fundbackend.vo.StockInFundResponse;
import org.nuptpig.fundcommon.Tools.MapperHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRatingRepository stockRatingRepository;

    public StockServiceImpl(StockRatingRepository stockRatingRepository) {
        this.stockRatingRepository = stockRatingRepository;
    }

    @Override
    public List<StockInFundResponse> getStocksForFund(String fundCode) {
        List<StockRating> stockRatings = stockRatingRepository.findAllByFundFundCode(fundCode);
        List<StockInFundResponse> stockInFundResponses = new ArrayList<>();
        for(StockRating stockRating : stockRatings){
            StockInFundResponse stockInFundResponse = MapperHelper.SourceToDestination(stockRating, StockInFundResponse.class);
            stockInFundResponse.setFunds(MapperHelper.SourcesToDestinations(stockRating.getStock().getFundList(), FundResponse.class));
            stockInFundResponses.add(stockInFundResponse);
        }
        return stockInFundResponses;
    }
}
