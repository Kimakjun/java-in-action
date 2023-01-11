package com.example.javainaction.chapter5;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 박싱비용 피하기 위해 기본형 특화 스트림을 사용한다
 *  mapToInt, mapToDouble, mapToLong ...
 *  Integer 는 sum 인터페이스를 제공한다.
 *
 *  반대로는?
 *  boxed 메서드를 이용해서 특화스트림 => 일반스트림으로 변환 가능하다.
 */
public class PrimitiveSpecificStream {

    @Test
    void TEST1(){
        IntStream intStream = Stream.of(1, 2, 3, 4).mapToInt(v -> v);
        Stream<Integer> IntegerStream = IntStream.of(1, 2, 3, 4).boxed();
    }

}
