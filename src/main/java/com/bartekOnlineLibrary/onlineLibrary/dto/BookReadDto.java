package com.bartekOnlineLibrary.onlineLibrary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookReadDto {
    String title;

    //AUTHOR
    String author;

    String content;
}
