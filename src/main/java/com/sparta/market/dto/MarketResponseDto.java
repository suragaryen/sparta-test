package com.sparta.memo.dto;

import com.sparta.memo.entity.Market;
import lombok.Getter;

@Getter
public class MarketResponseDto {
    private long id;
    private String username;
    private String contents;
    private String title;
    private int price;

    public MarketResponseDto(Market market) {
        this.id = market.getId();
        this.username = market.getUsername();
        this.contents = market.getContents();
        this.title = market.getTitle();
        this.price = market.getPrice();
    }

}