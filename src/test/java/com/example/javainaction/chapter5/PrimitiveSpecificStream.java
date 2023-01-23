package com.example.javainaction.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 박싱비용 피하기 위해 기본형 특화 스트림을 사용한다
 * mapToInt, mapToDouble, mapToLong ...
 * Integer 는 sum 인터페이스를 제공한다.
 * <p>
 * 반대로는?
 * boxed 메서드를 이용해서 특화스트림 => 일반스트림으로 변환 가능하다.
 */
public class PrimitiveSpecificStream {

    @Test
    void TEST1() {
        IntStream intStream = Stream.of(1, 2, 3, 4).mapToInt(v -> v);
        Stream<Integer> IntegerStream = IntStream.of(1, 2, 3, 4).boxed();
    }

    @Test
    void RANGE_TEST() {
        long evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .count();

        Assertions.assertEquals(evenNumbers, 50);

    }

    @Test
    void STREAM_FROM_STREAM_TEST() {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(numbers).sum();

        Assertions.assertEquals(sum, 15);
    }


    @Test
    void STREAM_FROM_FILE() {
        long uniqueWorlds = 0;
        String path = "/Users/user/Documents/serving/java-in-action/src/test/java/com/example/javainaction/files/data.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
            uniqueWorlds = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWorlds);
        } catch (IOException e) {

        }
    }

    @Test
    void ITERATE_TEST() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 종료 되지 않음 filter 대신 takeWhile(java 9 부터)
//        IntStream.iterate(0, n -> n + 4)
//                .filter(n -> n < 100)
//                .forEach(System.out::println);
    }




}
