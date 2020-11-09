package org.nuptpig.fundbackend.dao;

import org.nuptpig.fundbackend.entity.Fund;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FundRepository extends PagingAndSortingRepository<Fund, Long> {
    List<Fund> findAll();
}