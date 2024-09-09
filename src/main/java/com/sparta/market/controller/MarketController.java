package com.sparta.memo.controller;

import com.sparta.memo.dto.MarketRequestDto;
import com.sparta.memo.dto.MarketResponseDto;
import com.sparta.memo.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketController {


    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/memos")
    public MarketResponseDto createMemo(@RequestBody MarketRequestDto requestDto) {
        return marketService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MarketResponseDto> getMemos() {
        return marketService.getMemos();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MarketRequestDto requestDto) {
        return marketService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return marketService.deleteMemo(id);
    }
}