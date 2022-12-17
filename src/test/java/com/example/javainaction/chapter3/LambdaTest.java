package com.example.javainaction.chapter3;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * 함수형 인터페이스
 */
interface Runnable {
    void run();
}

interface Comparator<T> {
    int compare(T o1, T o2);
}

@FunctionalInterface
interface FucInterface<T> {
    boolean test(T t);

    default void defaultMethod() {
        System.out.println("디폴트 메서드");
    }

}

@FunctionalInterface
interface BufferedReaderProcess {
    String process(BufferedReader b) throws IOException;
}

public class LambdaTest {

    @Test
    public void functionalInterface() {
        try {
            Runnable r1 = () -> System.out.println("runnable");
            process(r1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void process(Runnable r) {
        r.run();
    }

    @Test
    public void test() {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
    }

    String processFile(BufferedReaderProcess p) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        } catch (IOException e) {
            return null;
        }
    }


}


