package org.nuptpig.fundbackend.service.serviceimpl;

import org.nuptpig.fundbackend.dao.FundRepository;
import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.service.FundService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundServiceImpl implements FundService {
    private final FundRepository fundRepository;

    public FundServiceImpl(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }

    @Override
    public List<Fund> getFunds() {
        return fundRepository.findAll();
    }

    @Override
    public Fund createFund(Fund fund) {
        return fundRepository.save(fund);
    }
}
