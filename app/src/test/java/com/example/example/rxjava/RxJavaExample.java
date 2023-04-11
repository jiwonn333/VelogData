package com.example.example.rxjava;

import org.junit.Test;

import java.util.stream.IntStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class RxJavaExample {
    private RxJavaExample demo;

    @Test
    public void main() {
        demo = new RxJavaExample();

        demo.emit_3();



    }

    public void emit_1() {
        Observable.just("Hello", "RxJava!")
                .subscribe(System.out::println);
    }


    public void emit_2() {
        // 2-1. just() 함수와 데이터 인자
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(System.out::println);

        /**
         * print-> 1
         *         2
         *         3
         *         4
         *         5
         *         6
         */

        // 2-4. create() 함수 활용
        Observable<Integer> source1 = Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(100);
            emitter.onNext(200);
            emitter.onNext(300);
            emitter.onComplete();
        });
        source1.subscribe(System.out::println);
        /**
         * print-> 100
         *         200
         *         300
         */


        // 2-5. subscribe() 함수 변경
        Observable<Integer> source2 = Observable.create((ObservableEmitter<Integer> emitter) -> {
            emitter.onNext(100);
            emitter.onNext(200);
            emitter.onNext(300);
            emitter.onComplete();
        });

        /**
         * print-> 100
         *         200
         *         300
         */


        // 2-6. 익명 객체 활용 예시
        source2.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer data) throws Exception {
                System.out.println("Result : " + data);
            }
        });
        // 람다 사용
        source2.subscribe(source2Result -> System.out.println("source2Result : " + source2Result));

    }


    public void emit_3() {
        /**
         * 복수 데이터 사용 함수
         */

        // fromArray()
        Integer[] arr = {100,200,300};
        Observable<Integer> source = Observable.fromArray(arr);

        source.subscribe(System.out::println);
        /**
         * print-> 100
         *         200
         *         300
         */

        // int 배열 처리시
        int[] intArray = {1,2,3};
        Observable.fromArray(intArray).subscribe(System.out::println);
        /**
         * print-> [I@5c86dbc5
         */

        // 1. Stream API 사용 방법
        Observable.fromArray(IntStream.of(intArray).boxed().toArray(Integer[]::new)).subscribe(System.out::println);

    }





}
