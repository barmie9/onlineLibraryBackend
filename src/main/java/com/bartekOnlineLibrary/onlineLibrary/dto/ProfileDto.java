package com.bartekOnlineLibrary.onlineLibrary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProfileDto {
    String name;
    String surname;
    String email;
    String dob;
    String photo;
}
