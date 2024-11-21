package com.wibmo.rewards.service;

import com.wibmo.rewards.dto.request.TransactionHistoryRequest;
import com.wibmo.rewards.dto.response.TransactionHistoryResponse;
import com.wibmo.rewards.model.CustomerTransactions;
import com.wibmo.rewards.repository.CustomerTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionHistoryService {

    @Autowired
    CustomerTransactionsRepository customerTransactionsRepository;

    public TransactionHistoryResponse getTransactionHistory(TransactionHistoryRequest request) {
        List<CustomerTransactions> transactions = customerTransactionsRepository.findByUserId(request.getUserId());
        return new TransactionHistoryResponse("200", "Transactions retrieved successfully", new Date(), transactions);
    }

}
