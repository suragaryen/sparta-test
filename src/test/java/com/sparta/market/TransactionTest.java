package com.sparta.memo;

import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MarketRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MarketRepository memoRepository;

    @Test
    @Transactional
    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
    @DisplayName("메모 생성 성공")
    void test1() {
        Memo memo = new Memo();
        memo.setUsername("Robbert");
        memo.setContents("@Transactional 테스트 중!");

        em.persist(memo);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }

    @Test
    @Disabled
    @DisplayName("메모 생성 실패") // insert,delete, update시에는 @Transactional 이 필수
    void test2() {
        Memo memo = new Memo();
        memo.setUsername("Robbie");
        memo.setContents("@Transactional 테스트 중!");

        em.persist(memo);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }

    // 스프링 컨테이너 환경에서는 영속성 컨텍스트와 트랜잭션의 생명주기가 일치한다

//    @Test
//    @Transactional
//    @Rollback(value = false)
//    @DisplayName("트랜잭션 전파 테스트")
//    void test3() { // 부모메서드
//        memoRepository.createMemo(em); // 자식메서드
//        System.out.println("테스트 test3 메서드 종료"); //자식 메서드의 transaction이 부모 메서드의 트랜잭션에 합쳐짐
//    }
}
