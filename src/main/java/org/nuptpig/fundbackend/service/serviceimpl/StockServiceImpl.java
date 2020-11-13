package org.nuptpig.fundbackend.service.serviceimpl;

import org.nuptpig.fundbackend.dao.StockRatingRepository;
import org.nuptpig.fundbackend.entity.StockRating;
import org.nuptpig.fundbackend.service.StockService;
import org.nuptpig.fundbackend.util.MapperHelper;
import org.nuptpig.fundbackend.vo.StockInFundResponse;
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
            stockInFundResponses.add(MapperHelper.SourceToDestination(stockRating.getStock(), StockInFundResponse.class));
        }
        return stockInFundResponses;
    }
}
