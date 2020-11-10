package org.nuptpig.fundbackend.controller;

import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.service.FundService;
import org.nuptpig.fundbackend.util.CommonResult;
import org.nuptpig.fundbackend.util.MapperHelper;
import org.nuptpig.fundbackend.vo.FundDetailResponse;
import org.nuptpig.fundbackend.vo.FundRequest;
import org.nuptpig.fundbackend.vo.FundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fund")
public class FundController {
    private final FundService fundService;

    @Autowired
    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    @GetMapping(path = "")
    public CommonResult getFunds(){
        List<FundResponse> fundResponses = fundService.getFunds();
        return CommonResult.success(fundResponses);
    }

    @PostMapping(path = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createFund(@RequestBody FundRequest fundRequest){
        Fund fund = MapperHelper.SourceToDestination(fundRequest, Fund.class);
        fundService.createFund(fund);
    }

    @GetMapping(value = "/{fundCode}")
    public CommonResult getFundByFundCode(@PathVariable String fundCode){
        FundDetailResponse fundDetailResponse = fundService.getFundByFundCode(fundCode);
        return CommonResult.success(fundDetailResponse);
    }
}
