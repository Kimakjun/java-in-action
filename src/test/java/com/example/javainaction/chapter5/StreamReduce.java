package com.example.javainaction.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {


    @Test
    void REDUCE_TEST() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        int max1 = numbers.stream().reduce(0, (a, b) -> a + b);
        int max2 = numbers.stream().reduce(0, Integer::sum);

        Assertions.assertEquals(max1, max2);

    }

}
