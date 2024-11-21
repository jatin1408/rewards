package com.wibmo.rewards.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String responseCode;
    private String responseMessage;
    private Long walletId;
    private String userType;
}

