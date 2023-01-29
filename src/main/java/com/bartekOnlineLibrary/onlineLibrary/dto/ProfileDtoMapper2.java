package com.bartekOnlineLibrary.onlineLibrary.dto;


import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileDtoMapper2 {
    private ProfileDtoMapper2(){};

    public static List<ProfileDto> mapProfile2DtoDtos(List<UserLibrary> profiles){
        return profiles.stream()
                .map(ProfileDtoMapper2::mapToProfile2Dto)
                .collect(Collectors.toList());
    }



    public static ProfileDto mapToProfile2Dto(UserLibrary profile){
        return ProfileDto.builder()
                .name(profile.getName())
                .surname(profile.getLastName())
                .email(profile.getEmail())
                .dob(profile.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")))
                .build();
    }
}
