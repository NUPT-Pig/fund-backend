package org.nuptpig.fundbackend.dao;

import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.entity.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FundRepository extends PagingAndSortingRepository<Fund, Long> {
    Page<Fund> findAll(Pageable pageable);
    List<Fund> findFundByFundCode(String fundCode);
    Fund getFundByFundCode(String fundCode);
}