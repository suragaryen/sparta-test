package com.sparta.memo.dto;

import lombok.Getter;

@Getter
public class MarketRequestDto {
    private String username;
    private String contents;
    private String title;
    private int price;
}