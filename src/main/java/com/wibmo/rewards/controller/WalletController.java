package com.wibmo.rewards.controller;

import com.wibmo.rewards.dto.request.PayToMerchantRequest;
import com.wibmo.rewards.dto.request.SendMoneyRequest;
import com.wibmo.rewards.dto.request.WalletDetailsRequest;
import com.wibmo.rewards.dto.response.PayToMerchantResponse;
import com.wibmo.rewards.dto.response.SendMoneyResponse;
import com.wibmo.rewards.dto.response.WalletDetailsResponse;
import com.wibmo.rewards.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class WalletController {
    @Autowired
    WalletService walletService;

    @PostMapping("/send-money")
    public ResponseEntity<SendMoneyResponse> sendMoney(@RequestBody @Valid SendMoneyRequest request) {
        return ResponseEntity.ok(walletService.sendMoney(request));
    }

    @PostMapping("/payToMerchant")
    public ResponseEntity<PayToMerchantResponse> payToMerchant(@RequestBody @Valid PayToMerchantRequest request) {
        return ResponseEntity.ok(walletService.payToMerchant(request));
    }

    @PostMapping("/wallet-details")
    public ResponseEntity<WalletDetailsResponse> viewWalletDetails(@RequestBody @Valid WalletDetailsRequest request) {
        return ResponseEntity.ok(walletService.viewWalletDetails(request));
    }

}
