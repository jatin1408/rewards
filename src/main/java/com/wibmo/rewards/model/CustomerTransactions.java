package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Customer_Transactions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnId;
    private Long userId;
    private Date reqDateTime;
    private Date resDateTime;
    private Long eventId;
    private Long txnAmt;
    private Integer mcc;
    private String txnStatus;
    private Long parentTxnId;
    private Long merchantId;
}

