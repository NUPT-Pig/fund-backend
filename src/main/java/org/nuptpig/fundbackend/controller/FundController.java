package org.nuptpig.fundbackend.controller;

import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.service.FundService;
import org.nuptpig.fundbackend.util.CommonResponse;
import org.nuptpig.fundbackend.util.CommonResult;
import org.nuptpig.fundbackend.util.MapperHelper;
import org.nuptpig.fundbackend.vo.FundDetailResponse;
import org.nuptpig.fundbackend.vo.FundRequest;
import org.nuptpig.fundbackend.vo.FundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getFunds(){
        // @todo   根据用户返回   admin返回所有     user返回各自的
        List<FundResponse> fundResponses = fundService.getFunds();
        return CommonResponse.ok(fundResponses);
    }

    @PostMapping(path = "")
    public ResponseEntity createFund(@RequestBody FundRequest fundRequest){
        Fund fund = MapperHelper.SourceToDestination(fundRequest, Fund.class);
        fundService.createFund(fund);
        return CommonResponse.ok(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{fundCode}")
    public ResponseEntity getFundByFundCode(@PathVariable String fundCode){
        FundDetailResponse fundDetailResponse = fundService.getFundByFundCode(fundCode);
        return CommonResponse.ok(fundDetailResponse);
    }

    @PostMapping(path = "/user_bind")
    public ResponseEntity userBind(){
        return CommonResponse.ok(HttpStatus.OK);
    }
}
