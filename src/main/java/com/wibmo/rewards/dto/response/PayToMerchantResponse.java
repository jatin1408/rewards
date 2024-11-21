package com.wibmo.rewards.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayToMerchantResponse {
    private String responseCode;
    private String responseMessage;
    private Date responseDatetime;
    private Long currentWalletBalance;
}
