package com.sparta.market.controller;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;
import com.sparta.market.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/api")
public class MarketController {


    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/")
    public String createMemo() {
        return "hello";
    }


    @PostMapping("/post")
    public MarketResponseDto createMemo(@RequestBody MarketRequestDto requestDto) {

        System.out.println(requestDto.toString());
        return marketService.createMarket(requestDto);
    }

    @GetMapping("/post")
    public List<MarketResponseDto> getMemos() {
        return marketService.getMarkets();
    }

    @PutMapping("/post/{id}")
    public MarketResponseDto updateMemo(@PathVariable("id") Long id, @RequestBody MarketRequestDto requestDto) {

        return marketService.updateMarket(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deleteMemo(@PathVariable("id") Long id) {
        marketService.deleteMarket(id);
        return ResponseEntity.ok().body(Map.of("msg", "삭제완료"));
    }
}