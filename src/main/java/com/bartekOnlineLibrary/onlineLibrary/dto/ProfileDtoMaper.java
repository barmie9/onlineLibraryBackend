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
                .name(profile.getName())
                .surname(profile.getLastName())
                .email(profile.getEmail())
                .dob(profile.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")))
//                .photo("http://localhost:8080/image/profile/"+ String.valueOf(profile.getId()) )
                .photo("https://static.zakumaj.pl/data/store/2015/10/98d0a565-4d35-88fb-5557-3977dee48380/picture_large.jpg")
                .build();
    }
}
