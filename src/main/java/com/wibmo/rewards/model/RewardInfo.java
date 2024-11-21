package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Reward_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnId;

    private Long userId;
    private Long rewardPoints;
    private Date rewardDateTime;
}
