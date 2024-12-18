package com.wibmo.rewards.service;

import com.wibmo.rewards.dto.request.PayToMerchantRequest;
import com.wibmo.rewards.dto.request.SendMoneyRequest;
import com.wibmo.rewards.dto.request.WalletDetailsRequest;
import com.wibmo.rewards.dto.response.PayToMerchantResponse;
import com.wibmo.rewards.dto.response.SendMoneyResponse;
import com.wibmo.rewards.dto.response.WalletDetailsResponse;
import com.wibmo.rewards.enums.EventTypes;
import com.wibmo.rewards.model.CustomerTransactions;
import com.wibmo.rewards.model.EventIdDetails;
import com.wibmo.rewards.model.MerchantDetails;
import com.wibmo.rewards.model.WalletDetails;
import com.wibmo.rewards.repository.CustomerTransactionsRepository;
import com.wibmo.rewards.repository.EventDetailsRepository;
import com.wibmo.rewards.repository.MerchantDetailsRepository;
import com.wibmo.rewards.repository.WalletDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WalletService {

    @Autowired
    WalletDetailsRepository walletDetailsRepository;

    @Autowired
    CustomerTransactionsRepository customerTransactionsRepository;

    @Autowired
    MerchantDetailsRepository merchantDetailsRepository;

    @Autowired
    EventDetailsRepository eventDetailsRepository;

    public SendMoneyResponse sendMoney(SendMoneyRequest request) {
        // Fetch sender's wallet
        WalletDetails senderWallet = walletDetailsRepository.findByMobileNumber(request.getSenderMobileNumber())
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));

        // Validate balance
        if (senderWallet.getBalance() < request.getTxnAmount()) {
            return new SendMoneyResponse("400", "Insufficient balance", new Date(), senderWallet.getBalance());
        }

        // Fetch receiver's wallet
        WalletDetails receiverWallet = walletDetailsRepository.findByMobileNumber(request.getReceiverMobileNumber())
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        // Deduct and Add Amount
        senderWallet.setBalance(senderWallet.getBalance() - request.getTxnAmount());
        receiverWallet.setBalance(receiverWallet.getBalance() + request.getTxnAmount());

        walletDetailsRepository.save(senderWallet);
        walletDetailsRepository.save(receiverWallet);
        EventIdDetails eventIdDetails = eventDetailsRepository.findByEventType(EventTypes.WALLET_LOAD.getEventType()).orElseThrow(() -> new RuntimeException("No event mapping found"));
        // Log transaction
        customerTransactionsRepository.save(CustomerTransactions.builder().txnAmt(request.getTxnAmount())
                .eventId(eventIdDetails.getEventId())
                .reqDateTime(request.getRequestDatetime())
                .resDateTime(new Date())
                .userId(receiverWallet.getUserId())
                .build());
        eventIdDetails = eventDetailsRepository.findByEventType(EventTypes.WALLET_UNLOAD.getEventType()).orElseThrow(() -> new RuntimeException("No event mapping found"));
        customerTransactionsRepository.save(CustomerTransactions.builder().txnAmt(request.getTxnAmount())
                .eventId(eventIdDetails.getEventId())
                .reqDateTime(request.getRequestDatetime())
                .resDateTime(new Date())
                .userId(senderWallet.getUserId())
                .build());

        return new SendMoneyResponse("200", "Transaction successful", new Date(), senderWallet.getBalance());
    }

    public PayToMerchantResponse payToMerchant(PayToMerchantRequest request) {
        // Fetch sender's wallet
        WalletDetails senderWallet = walletDetailsRepository.findByMobileNumber(request.getSenderMobileNumber())
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));

        // Validate balance
        if (senderWallet.getBalance() < request.getTxnAmount()) {
            return new PayToMerchantResponse("400", "Insufficient balance", new Date(), senderWallet.getBalance());
        }

        MerchantDetails merchantDetails = merchantDetailsRepository.findByMerchantId(request.getMerchantId())
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        // Deduct and Add Amount
        senderWallet.setBalance(senderWallet.getBalance() - request.getTxnAmount());

        walletDetailsRepository.save(senderWallet);
        EventIdDetails eventIdDetails = eventDetailsRepository.findByEventType(EventTypes.WALLET_LOAD.getEventType()).orElseThrow(() -> new RuntimeException("No event mapping found"));
        // Log transaction
        customerTransactionsRepository.save(CustomerTransactions.builder().txnAmt(request.getTxnAmount())
                .eventId(eventIdDetails.getEventId())
                .reqDateTime(request.getRequestDatetime())
                .resDateTime(new Date())
                .merchantId(request.getMerchantId())
                .build());

        return new PayToMerchantResponse("200", "Transaction successful", new Date(), senderWallet.getBalance());
    }

    public WalletDetailsResponse viewWalletDetails(WalletDetailsRequest request) {
        WalletDetails wallet = walletDetailsRepository.findByMobileNumber(request.getMobileNumber())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        return new WalletDetailsResponse(
                "200",
                "Wallet details retrieved successfully",
                new Date(),
                wallet.getBalance(),
                wallet.getRewardPoints()
        );
    }


}
