package com.wibmo.rewards.controller;

import com.wibmo.rewards.dto.request.TransactionHistoryRequest;
import com.wibmo.rewards.dto.response.TransactionHistoryResponse;
import com.wibmo.rewards.service.TransactionHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TransactionHistoryController {

    @Autowired
    TransactionHistoryService transactionHistoryService;

    @PostMapping("/transaction-history")
    public ResponseEntity<TransactionHistoryResponse> getTransactionHistory(@RequestBody @Valid TransactionHistoryRequest request) {
        return ResponseEntity.ok(transactionHistoryService.getTransactionHistory(request));
    }

}
