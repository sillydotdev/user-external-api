package com.assignment.demo.dto;

import lombok.Data;

@Data
public class CryptoDto {
    private String coin;
    private String wallet;
    private String network;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public CryptoDto() {
    }
}
