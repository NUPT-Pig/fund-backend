package org.nuptpig.fundbackend.dao;

import org.nuptpig.fundbackend.entity.Fund;
import org.nuptpig.fundbackend.entity.UserBinding;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserBindingRepository extends PagingAndSortingRepository<UserBinding, Long> {
    List<UserBinding> findAllByUserName(String userName);
    Boolean existsUserBindingByFundAndUserName(Fund fund, String userName);
    UserBinding getByUserNameAndFund(String userName, Fund fund);
    UserBinding getUserBindingByFundAndUserName(Fund fund, String userName);
}
