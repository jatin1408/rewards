package com.wibmo.rewards.repository;

import com.wibmo.rewards.model.MerchantDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantDetailsRepository extends JpaRepository<MerchantDetails, Long> {

    Optional<MerchantDetails> findByMerchantId(Long merchantId);
}
