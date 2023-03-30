package com.example.example.rxjava;

import org.junit.Test;
import io.reactivex.Observable;

public class FirstExample {
    @Test
    public void main() {
        FirstExample demo = new FirstExample();
        demo.emit();
    }

    public void emit() {
        Observable.just("Hello", "RxJava!")
                .subscribe(System.out::println);
    }
}
