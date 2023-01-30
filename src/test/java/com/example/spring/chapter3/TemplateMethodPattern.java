package com.example.spring.chapter3;

import org.junit.jupiter.api.Test;

public class TemplateMethodPattern {

    @Test
    void templateMethodPattern() {

        ClassA a = new ClassA();
        ClassB b = new ClassB();

        a.somethingSame();
        b.somethingSame();

    }

}

class ClassA extends Something {

    @Override
    protected void somethingDiff() {
        System.out.println("AA");
    }
}

class ClassB extends Something {

    @Override
    protected void somethingDiff() {
        System.out.println("BB");
    }
}


abstract class Something {
    abstract protected void somethingDiff();

    protected void somethingSame() {
        System.out.println("동일한 부분 시작");
        somethingDiff();
        System.out.println("동일한 부분 끝");
    }

}


