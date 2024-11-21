package com.wibmo.rewards.dto.response;

import com.wibmo.rewards.model.CustomerTransactions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryResponse {
    private String responseCode;
    private String responseMessage;
    private Date responseDatetime;
    private List<CustomerTransactions> transactionDetails;
}
