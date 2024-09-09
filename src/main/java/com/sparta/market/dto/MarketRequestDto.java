package com.sparta.market.dto;

import lombok.Getter;

@Getter
public class MarketRequestDto {
    private String username;
    private String title;
    private String content;
    private int price;
}