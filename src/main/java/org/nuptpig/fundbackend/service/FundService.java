package org.nuptpig.fundbackend.service;

import org.nuptpig.fundbackend.entity.Fund;

import java.util.List;

public interface FundService {
    public List<Fund> getFunds();
    public Fund createFund(Fund fund);
}
