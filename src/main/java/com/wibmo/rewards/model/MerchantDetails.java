package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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
    @CreationTimestamp
    private Date merchantCreationDate;
    @UpdateTimestamp
    private Date merchantUpdateDate;
}

