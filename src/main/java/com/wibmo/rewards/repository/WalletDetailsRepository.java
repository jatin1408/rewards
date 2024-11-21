package com.wibmo.rewards.repository;

import com.wibmo.rewards.model.WalletDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletDetailsRepository extends JpaRepository<WalletDetails, Long> {
    Optional<WalletDetails> findByMobileNumber(String mobileNumber);

    Optional<WalletDetails> findByUserId(Long userId);
}
