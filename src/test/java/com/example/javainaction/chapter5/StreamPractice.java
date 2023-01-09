package com.example.javainaction.chapter5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    private List<Transaction> transactions;

    @BeforeAll
    void setup(){
        Trader r = new Trader("R", "CBcity");
        Trader m = new Trader("M", "Mcity");
        Trader a = new Trader("A", "CBcity");
        Trader b = new Trader("B", "CBcity");

        transactions = Arrays.asList(
                new Transaction(b, 2011, 300),
                new Transaction(r, 2012, 1000),
                new Transaction(r, 2011, 400),
                new Transaction(m, 2012, 710),
                new Transaction(m, 2012, 700),
                new Transaction(a, 2012, 950)
        );
    }

    @Test
    void TEST1(){
        // year 2011, 오름차순 정렬

        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(Collectors.toList());

    }


    @Test
    void TEST2(){
        // 고유 도시 출력
    }

    @Test
    void TEST3(){
        // CBcity 거래자 이름순 정렬
    }

    @Test
    void TEST4(){
        // 모든 거래자 이름 정렬
    }

    @Test
    void TEST5(){
        // Mcity 거래자 존재 여부 출력
    }

    @Test
    void TEST6(){
        // CBcity 거래자 모든 transaction 출력
    }

    @Test
    void TEST7(){
        // 전체 트랜잭션중 최댓값
    }

    @Test
    void TEST8(){
        // 전체 트랜잭션중 최소값
    }

}

class Trader {
    private final String name;
    private final String city;

    Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}


class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }
}