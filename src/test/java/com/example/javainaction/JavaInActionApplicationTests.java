package com.example.javainaction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class JavaInActionApplicationTests {

    @Test
    void contextLoads() {

        int[] result = solution("foobar");
        System.out.println(Arrays.toString(result));
    }

    @Test()
    int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> charPositionMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int position = charPositionMap.getOrDefault(c, -1);
            charPositionMap.put(c, i);

            if (position != -1) {
                position = i - position;
            }

            answer[i] = position;
        }

        return answer;
    }

}
