package com.bartekOnlineLibrary.onlineLibrary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookDescDto {
    String title;
    int price;
    String genreText;
    String descriptionLong;
    int rating;
    String picture;

}
