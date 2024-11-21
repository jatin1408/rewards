package com.wibmo.rewards.repository;


import com.wibmo.rewards.model.EventIdDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventDetailsRepository extends JpaRepository<EventIdDetails, Long> {
    Optional<EventIdDetails> findByEventType(String eventType);
}
