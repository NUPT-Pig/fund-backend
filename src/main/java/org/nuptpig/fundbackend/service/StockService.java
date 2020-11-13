package org.nuptpig.fundbackend.service;

import org.nuptpig.fundbackend.vo.StockInFundResponse;

import java.util.List;

public interface StockService {
    List<StockInFundResponse> getStocksForFund(String fundCode);
}
