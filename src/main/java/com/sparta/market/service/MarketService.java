package com.sparta.market.service;


import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;
import com.sparta.market.entity.Market;
import com.sparta.market.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public MarketResponseDto createMarket(MarketRequestDto requestDto) {
        // RequestDto -> Entity
        Market market = new Market(requestDto);

        // DB 저장
        Market savedMarket = marketRepository.save(market);

        // Entity -> ResponseDto
        MarketResponseDto marketResponseDto = new MarketResponseDto(savedMarket);

        return marketResponseDto;
    }

    public List<MarketResponseDto> getMarkets() {
        // DB 조회
        return marketRepository.findAll().stream().map(MarketResponseDto::new).toList();
    }

    @Transactional
    public MarketResponseDto updateMarket(Long id, MarketRequestDto requestDto) {
        // 해당 Market이 DB에 존재하는지 확인
        Market market = findMarket(id);

        market.update(requestDto);


        // Market 내용 수정
        MarketResponseDto marketResponseDto = new MarketResponseDto(market);

        return marketResponseDto;
    }

    public Long deleteMarket(Long id) {
        // 해당 Market이 DB에 존재하는지 확인
        Market market = findMarket(id);

        // Market 삭제
        marketRepository.delete(market);

        return id;
    }

    private Market findMarket(Long id) {
        return marketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 Market은 존재하지 않습니다.")
        );
    }
}
