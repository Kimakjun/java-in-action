package com.example.javainaction.chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * - 람다 표현식은 익명 함수의 일종
 * - 함수형인터페이스는 하나의 추상 메서드만을 정의하는 인터페이스이다.
 * - 함다 표현식 전체가 함수형 인터페이스의 인스턴스로 취급된다.
 * - 자바 8 은 박싱 동작을 피할 수 있는 IntPredicate 등과 같은 기본형 특화 인터페이스도 제공을 한다.
 * - 함수형 인터페이스는 람다 표현식을 조합할 수 있는 다양한 디폴트 메서드를 제공한다.
 */
public class FunctionTest {

    @Test()
    void Function_조합_테스트() {

        // given
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        // when
        Function<Integer, Integer> andThenFunction = f.andThen(g);
        Function<Integer, Integer> composeFunction = f.compose(g);

        // then
        Assertions.assertEquals(andThenFunction.apply(2), 6);
        Assertions.assertEquals(composeFunction.apply(2), 5);
    }

    @Test()
    void Function_조합_테스트2() {
        // given Letter class

        // when
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        // then
        Assertions.assertEquals(transformationPipeline.apply("lamda"), "Header lambda Footer");
    }
}

class Letter {
    public static String addHeader(String text) {
        return "Header " + text;
    }

    public static String addFooter(String text) {
        return text + " Footer";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("lamda", "lambda");
    }
}