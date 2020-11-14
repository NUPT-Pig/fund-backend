package org.nuptpig.fundbackend.dao;

import org.nuptpig.fundbackend.entity.UserBinding;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserBindingRepository extends PagingAndSortingRepository<UserBinding, Long> {
    List<UserBinding> findAllByUserName(String userName);
}
