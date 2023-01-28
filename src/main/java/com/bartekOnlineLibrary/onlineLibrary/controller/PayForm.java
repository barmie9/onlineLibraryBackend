package com.bartekOnlineLibrary.onlineLibrary.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayForm {
    private String method;
    private String blikCode;
    private String cardData;
}
