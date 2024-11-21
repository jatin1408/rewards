package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Wallet_details")
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
    private Date walletCreationDate;
    private Date walletUpdateDate;
    private Long rewardPoints;
}

