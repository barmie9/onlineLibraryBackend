package com.bartekOnlineLibrary.onlineLibrary.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordForm {
    String old;
    String newPassword;
    String confirm;
}
