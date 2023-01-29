package com.bartekOnlineLibrary.onlineLibrary.dto;


import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileDtoMaper {
    private ProfileDtoMaper(){};

    public static List<ProfileDto> mapProfileDtoDtos(List<UserLibrary> profiles){
        return profiles.stream()
                .map(ProfileDtoMaper::mapToProfileDto)
                .collect(Collectors.toList());
    }



    public static ProfileDto mapToProfileDto(UserLibrary profile){
        return ProfileDto.builder()
                .id(profile.getId())
                .name(profile.getName())
                .surname(profile.getLastName())
                .email(profile.getEmail())
                .dob(profile.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")))
                .build();
    }
}
