package com.example.javainaction.chapter6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// public interface Collector<T, A, R>
// T 수집될 스트림 항목의 제너럴 형식
// A 누적자, 수직 과정에서 중간 결과를 누적하는 객체 형식
// R 수집 연산 결과 객체의 형식

public class CollectorTest {

    @Test()
    public void CollectorTest(){

    }

}


class CustomCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return null;
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }



}
