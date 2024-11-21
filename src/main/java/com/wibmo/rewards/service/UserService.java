package com.wibmo.rewards.service;

import com.wibmo.rewards.dto.request.LoginRequest;
import com.wibmo.rewards.dto.request.SignUpRequest;
import com.wibmo.rewards.dto.response.LoginResponse;
import com.wibmo.rewards.dto.response.SignUpResponse;
import com.wibmo.rewards.model.UserDetails;
import com.wibmo.rewards.model.WalletDetails;
import com.wibmo.rewards.repository.UserDetailsRepository;
import com.wibmo.rewards.repository.WalletDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    WalletDetailsRepository walletDetailsRepository;

    public SignUpResponse signUp(SignUpRequest request) {
        UserDetails user = new UserDetails();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setMobileNumber(request.getMobileNumber());
        user.setUserCategory(request.getUserCategory());
        user.setCreationDate(new Date());
        UserDetails savedUser = userDetailsRepository.save(user);


        WalletDetails wallet = new WalletDetails();
        wallet.setUserId(savedUser.getUserId());
        wallet.setBalance(0L);
        wallet.setWalletStatus(1);
        wallet.setWalletCreationDate(new Date());
        WalletDetails savedWallet = walletDetailsRepository.save(wallet);

        return new SignUpResponse(
                savedUser.getUserId(),
                "200",
                "User registered successfully",
                savedWallet.getWalletId()
        );
    }

    public LoginResponse login(LoginRequest request) {
        UserDetails user = userDetailsRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        WalletDetails wallet = walletDetailsRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        return new LoginResponse("200", "Login successful", wallet.getWalletId(), user.getUserCategory());
    }


}
