package com.wibmo.rewards.repository;

import com.wibmo.rewards.model.CustomerTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerTransactionsRepository extends JpaRepository<CustomerTransactions, Long> {
    List<CustomerTransactions> findByUserId(Long userId);

}
