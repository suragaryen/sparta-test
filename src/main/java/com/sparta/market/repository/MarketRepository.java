package com.sparta.memo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // SimpleJpaRepository가 자동으로 빈으로 등록하기 때문에 @Repository가 없어도 등록됌
public interface MarketRepository extends JpaRepository<MarketRepository, Long> {

    List<MarketRepository> findAllByOrderByModifiedAtDesc();


}