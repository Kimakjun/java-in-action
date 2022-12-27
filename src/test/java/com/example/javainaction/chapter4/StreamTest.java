package com.example.javainaction.chapter4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 스트림 API
 * - 선언형: 간결하고 가독성이 좋다
 * - 조립성: 유연성이 좋아진다
 * - 병렬화: 성능이 좋아진다
 *
 * 생각해볼점
 * - 스트림이 항상 성능이 좋을까?
 *  - 스트림 사용이 일반 외부반복문보다 의미가 있으려면 cpu 연산이 바쁠만큼 비용이 비싸야한다
 *  - 병렬스트림을 사용하려면 스트림 소스인 collection 이 split 하기 쉬운 구조거나 상태가 없어야한다.
 *  - 병렬스트림 자체에 비용도 적지 않기 때문에 잘고려해야한다.
 *     - 포크조인풀 객체 생성비용, job split 비용 등 보다 연산의 복잡도가 커 단일 스트림보다 병렬스트림을 사용하는 것이 우위에 있을때 사용하자.
 *     - 이부분은 복잡한 경우 테스트가 필요할 듯 하다.
 *
 * 정리
 * - 스트림은 소스에서 추출된 연속 요소러, 데이터 처리 연산을 지원
 * - 스트림은 내부반복을 지원, 내부 반복은 filter, map, sorted 등의 연상으로 반복을 추상화, 직접 요소를 코드에서 가져와 처리하지 않음
 * - 중간연산은 또다른 스트림을 반환하고 중간 연산은 어떠한 결과도 생성하지 않는다
 * - 최종연산은 스트림이 아닌 결과를 반환하는 연산이다.
 * - 스트림의 요소는 요청할때 게으르게, lazy 하게 계산된다.
 */
public class StreamTest {

    @Test
    void 스트림소비_테스트() {
        /**
         * 스트림은 단 한번만 소비될 수 있다.
         */
        Assertions.assertThrows(IllegalStateException.class, () -> {
            List<String> title = Arrays.asList("a", "b", "c");
            Stream<String> s = title.stream();
            s.forEach(System.out::println);
            s.forEach(System.out::println); // 두번 소비될 수 없음
        });
    }

}
