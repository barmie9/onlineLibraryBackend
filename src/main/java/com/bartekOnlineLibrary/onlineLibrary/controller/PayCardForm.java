package com.bartekOnlineLibrary.onlineLibrary.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayCardForm {
    String processor;
    String numer;
    String cvv;
    String holder;
}
