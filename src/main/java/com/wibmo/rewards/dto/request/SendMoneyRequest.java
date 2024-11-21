package com.wibmo.rewards.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMoneyRequest {
    private String txnId;
    private Integer eventId;
    private Date requestDatetime;
    private String receiverMobileNumber;
    private Long txnAmount;
    private String senderMobileNumber;
}