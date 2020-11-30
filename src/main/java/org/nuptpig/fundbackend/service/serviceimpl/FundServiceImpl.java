package org.nuptpig.fundbackend.service.serviceimpl;

import org.nuptpig.fundbackend.dao.FundRepository;
import org.nuptpig.fundbackend.dao.UserBindingRepository;
import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.entity.UserBinding;
import org.nuptpig.fundbackend.service.FundService;
import org.nuptpig.fundbackend.util.MapperHelper;
import org.nuptpig.fundbackend.vo.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class FundServiceImpl implements FundService {
    private final FundRepository fundRepository;
    private final UserBindingRepository userBindingRepository;

    public FundServiceImpl(FundRepository fundRepository, UserBindingRepository userBindingRepository) {
        this.fundRepository = fundRepository;
        this.userBindingRepository = userBindingRepository;
    }

    @Override
    public PageableFundResponse getFunds(Pageable pageable) {
        Page<Fund> funds = fundRepository.findAll(pageable);
        return new PageableFundResponse(funds.getTotalElements(), funds.getTotalPages(), MapperHelper.SourcesToDestinations(funds.toList(), FundResponse.class));
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

    @Override
    public Boolean bindUser(UserBindRequest userBindRequest) {
        UserBinding userBinding = MapperHelper.SourceToDestination(userBindRequest, UserBinding.class);
        Fund fund = fundRepository.getFundByFundCode(userBindRequest.getFundCode());
        if (fund == null){
            return false;
        }
        userBinding.setFund(fund);
        userBindingRepository.save(userBinding);
        return true;
    }
}
