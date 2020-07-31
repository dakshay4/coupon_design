package com.dakshay.wallet.controller;

import com.dakshay.wallet.request.WalletRequestBean;
import com.dakshay.wallet.response.WalletResponseBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dakshay on 11/22/2018.
 */
@RestController
public class WalletController {

    @PostMapping (path="/walletdetails")
    public WalletResponseBean getWalletDetails(@RequestBody WalletRequestBean walletRequestBean){

        return null;
    }

}
