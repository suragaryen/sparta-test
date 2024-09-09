package com.sparta.memo.service;

import com.sparta.memo.dto.MarketRequestDto;
import com.sparta.memo.dto.MarketResponseDto;
import com.sparta.memo.entity.Market;
import com.sparta.memo.repository.MarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public MarketResponseDto createMemo(MarketRequestDto requestDto) {
        // RequestDto -> Entity
        Market market = new Market(requestDto);

        // DB 저장
        Market saveMarket = marketRepository.saveAll(market);

        // Entity -> ResponseDto
        MarketResponseDto marketResponseDto = new MarketResponseDto(saveMarket);

        return marketResponseDto;
    }

    public List<MarketResponseDto> getMemos() {
        // DB 조회
        return marketRepository.findAllByOrderByModifiedAtDesc().stream().map(MarketResponseDto::new).toList();
    }

    @Transactional
    public Long updateMemo(Long id, MarketRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Market market = findMemo(id);

        // memo 내용 수정
        market.update(requestDto);

        return id;
    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);

        // memo 삭제
        memoRepository.delete(memo);

        return id;
    }

    private Memo findMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}