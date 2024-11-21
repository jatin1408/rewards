package com.wibmo.rewards.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String txnId;
    private Date requestDateTime;
    private Long userId;
}
