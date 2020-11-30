package org.nuptpig.fundbackend.controller;

import org.nuptpig.fundbackend.service.StockService;
import org.nuptpig.fundbackend.util.CommonResponse;
import org.nuptpig.fundbackend.vo.StockInFundResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/fund/stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(path = "/stocks_in_fund")
    //获取基金持仓详情
    public ResponseEntity getStocks4Fund(@RequestParam(value = "fund_code") String fundCode){
        List<StockInFundResponse> stockInFundResponses = stockService.getStocksForFund(fundCode);
        return CommonResponse.ok(stockInFundResponses);
    }
}
