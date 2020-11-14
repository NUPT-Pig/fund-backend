package org.nuptpig.fundbackend.service.serviceimpl;

import org.nuptpig.fundbackend.dao.FundRepository;
import org.nuptpig.fundbackend.dao.UserBindingRepository;
import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.entity.UserBinding;
import org.nuptpig.fundbackend.service.FundService;
import org.nuptpig.fundbackend.util.MapperHelper;
import org.nuptpig.fundbackend.vo.FundDetailResponse;
import org.nuptpig.fundbackend.vo.FundResponse;
import org.nuptpig.fundbackend.vo.FundsInUserResponse;
import org.springframework.stereotype.Service;

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
        return MapperHelper.SourceToDestination(fund, FundDetailResponse.class);
    }

    @Override
    public List<FundsInUserResponse> getFundsByUserName(String userName) {
        List<UserBinding> userBindings = userBindingRepository.findAllByUserName(userName);
        return MapperHelper.SourcesToDestinations(userBindings, FundsInUserResponse.class);
    }
}
