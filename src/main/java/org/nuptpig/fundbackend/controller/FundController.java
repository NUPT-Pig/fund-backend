package org.nuptpig.fundbackend.controller;

import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.service.FundService;
import org.nuptpig.fundbackend.util.CommonResponse;
import org.nuptpig.fundbackend.util.CommonResult;
import org.nuptpig.fundbackend.util.MapperHelper;
import org.nuptpig.fundbackend.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity getFunds(@RequestParam(value = "per_page", required = false, defaultValue = "20") int perPage,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestHeader(value = "token", required = false) String userName){
        // @todo   根据用户返回   admin返回不加关注状态     user返回加关注状态
        System.out.println(userName);
        Pageable pageable = PageRequest.of(page-1, perPage);
        PageableFundResponse pageableFundResponse = fundService.getFunds(pageable);
        return CommonResponse.ok(pageableFundResponse);
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
    public ResponseEntity userBind(@RequestBody UserBindRequest userBindRequest){
        if (fundService.bindUser(userBindRequest)) {
            return CommonResponse.ok(HttpStatus.OK);
        }
        else{
            return CommonResponse.fail(HttpStatus.BAD_REQUEST);
        }
    }

    // @TODO 基金体检，准备购买的基金和已经持有的基金关系图谱（可以把基金图谱简化，平时看不需要那么详细信息）
    //  所以基金和用户绑定先做   用户注册先做
}
