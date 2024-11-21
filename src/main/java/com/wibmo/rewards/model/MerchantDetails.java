package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Merchant_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchantId;
    private Long userId;
    private Integer mcc;
    private Integer merchantStatus;
    private LocalDateTime merchantCreationDate;
    private LocalDateTime merchantUpdateDate;
}

