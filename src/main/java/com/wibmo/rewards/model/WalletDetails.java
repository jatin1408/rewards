package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "wallet_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    private Long userId;
    private Long balance;
    private Integer walletStatus;
    @CreationTimestamp
    private Date walletCreationDate;
    @UpdateTimestamp
    private Date walletUpdateDate;
    private Long rewardPoints;
    private String mobileNumber;
}

