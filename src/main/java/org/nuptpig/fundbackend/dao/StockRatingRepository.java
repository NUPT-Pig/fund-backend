package org.nuptpig.fundbackend.dao;

import org.nuptpig.fundbackend.entity.StockRating;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StockRatingRepository extends PagingAndSortingRepository<StockRating, Long> {
    List<StockRating> findAllByFundFundCode(String fundCode);
    List<StockRating> findAllByStockStockCode(String stockCode);
}
