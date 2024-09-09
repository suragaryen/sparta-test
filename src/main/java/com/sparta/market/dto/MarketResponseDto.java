package com.sparta.market.dto;

import com.sparta.market.entity.Market;
import lombok.Getter;

@Getter
public class MarketResponseDto {
    private long id;
    private String username;
    private String content;
    private String title;
    private int price;

    public MarketResponseDto(Market market) {
        this.id = market.getId();
        this.username = market.getUsername();
        this.content = market.getContent();
        this.title = market.getTitle();
        this.price = market.getPrice();
    }


}