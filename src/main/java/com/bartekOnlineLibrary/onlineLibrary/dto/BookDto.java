package com.bartekOnlineLibrary.onlineLibrary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString
public class BookDto  {
    private long id;
    private String title;
    private int price;
    private String content;

    private String name;

}
