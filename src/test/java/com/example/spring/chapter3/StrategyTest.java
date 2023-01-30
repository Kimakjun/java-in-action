package com.example.spring.chapter3;

// 전략 패턴
// client 전략 결정 => 전략 => Context(바뀌지 않는 부분) 에게 전달
// 오브젝트를 생성하고 컨텍스트로 전달... DI!!

import org.junit.jupiter.api.Test;

public class StrategyTest {


    @Test
    public void 전략테스트(){
        파출소 파출소 = new 파출소();
        몽둥이 쇠파이프 = new 쇠파이프();

        파출소.혼내줘(쇠파이프);


    }

}


interface SomethingStrategy {
    String something();
}



interface 몽둥이 {
    void 때려();
}

class 쇠파이프 implements 몽둥이 {

    @Override
    public void 때려() {
        System.out.println("아파!!!");
    }
}

class 나무막대기 implements 몽둥이 {

    @Override
    public void 때려() {
        System.out.println("아파!");
    }
}


class 파출소 {

    public void 혼내줘(몽둥이 몽둥이){
        System.out.println("맞아야해..");
        몽둥이.때려();
        System.out.println("다음 부턴 그러지마..");
    }

}

