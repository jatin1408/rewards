package com.wibmo.rewards.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String txnId;
    private Date requestDateTime;
    private String firstName;
    private String lastName;
    private Long userId;
    private String password;
    private String userCategory;
    private String mobileNumber;
}
