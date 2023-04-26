package com.example.example.rxjava.observable;

import com.example.example.rxjava.common.Order;

import org.junit.Test;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class RxJavaExample {

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

    @Test
    public void emit_3() {
        /**
         * 복수 데이터 사용 함수ㅅ
         */

        // fromArray()
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);

        source.subscribe(System.out::println);
        /**
         * print-> 100
         *         200
         *         300
         */

        // int 배열 처리시
        int[] intArray = {1, 2, 3};
        Observable.fromArray(intArray).subscribe(System.out::println);
        /**
         * print-> [I@5c86dbc5
         */

        // 1. Stream API 사용 방법
        Observable.fromArray(IntStream.of(intArray).boxed().toArray(Integer[]::new)).subscribe(System.out::println);


        /**
         * Iterable<E> 인터페이스를 구현하는 대표적인 클래스 중
         * List, Set, BlockingQueue 인터페이스 객체의 Observable 생성 방법에 대해 다룰 예정.
         */
        // 1. fromIterable()에 List 사용
        List<String> names = new ArrayList<>();
        names.add("jiwon");
        names.add("shin");

        Observable<String> nameSource = Observable.fromIterable(names);
        startPrint(nameSource);

        // 2. fromIterable()에 Set 사용
        Set<String> cities = new HashSet<>();
        cities.add("서울");
        cities.add("송파구");

        Observable<String> citySource = Observable.fromIterable(cities);
        startPrint(citySource);


        // 3. fromIterable()에 BlockingQueue 사용
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
        orderQueue.add(new Order("ord-1"));
        orderQueue.add(new Order("ord-2"));
        orderQueue.add(new Order("ord-3"));

        Observable<Order> orderSource = Observable.fromIterable(orderQueue);
        startPrint(orderSource);


        /**
         * Callable 객체와 fromCallable() 함수를 이용해 Observable 생성
         */

        // 람다 표현식 활용한 fromCallable()
        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "Hello Callable";
        };
        Observable<String> callableSource = Observable.fromCallable(callable);
        startPrint(callableSource);

        /**
         * 보통 Executor 인터페이스를 구현한 클래스에 Callable 객체를 인자로 넣어
         * Future 객체 반환
         */

        // 람다 표현식 활용한  fromFuture()
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(1000);
            return "Hello Future";
        });

        Observable<String> futureSource = Observable.fromFuture(future);
        startPrint(futureSource);


        // fromPublisher() 함수 활용
        Publisher<String> publisher = s -> {
            s.onNext("Observable.formPublisher");
            s.onComplete();
        };
        Observable<String> publisherSource = Observable.fromPublisher(publisher);
        startPrint(publisherSource);

    }


    public void startPrint(Observable source) {
        source.subscribe(System.out::println);
    }


}
