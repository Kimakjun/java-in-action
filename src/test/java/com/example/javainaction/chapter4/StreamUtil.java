package com.example.javainaction.chapter4;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 1. filter
 * 2. distinct: 고유 여부는 스트림 객체의 hashcode, equals
 * 3. skip
 * 4. limit
 * 5. map
 * 6. flatMap
 * 6. allMatch, anyMatch, noneMatch, findAny, findFirst
 */
public class StreamUtil {


    @Test
    void 스트림_API_테스트() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = list.stream().filter(i -> i % 2 == 0)
                .skip(2)
                .limit(2)
                .collect(toList());

        result.stream().forEach(System.out::println);

        // map
        List<String> words = Arrays.asList("hakjun", "noel", "heaji");
        List<Integer> wordsLengths = words.stream().map(String::length).collect(toList());

        wordsLengths.stream().forEach(System.out::println);

        // stream 평면화
        List<String> distinctWords =  words.stream().map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(Arrays.toString(distinctWords.toArray()));



    }


}
