package com.example.zen.concurrency;

import com.example.zen.lambda.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ZenConcurrency {

    public static void main(String[] args){
        ZenConcurrency z = new ZenConcurrency();

        //z.conc();
        z.call();
    }

    private void conc(){

        Runnable r = () ->
                System.out.println(Thread.currentThread().getName());

        r.run();

        Thread t = new Thread(r);
        t.start();

    }

    private void executor(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit( () -> System.out.println(Thread.currentThread().getName()));
        executor.shutdownNow();
        System.out.println(executor.isTerminated());
    }

    private void call() {
        Test ze = new Test("Test1", 20);

        List<Test> listTest = new ArrayList<>();

        ExecutorService executor = Executors.newWorkStealingPool();

        for (int i =0 ; i < 100; i++){
            Test ze1 = new Test("Test"+i, 20);
            listTest.add(ze1);
        }

        try {
            executor.invokeAll(listTest).forEach((a) -> {
                try {
                    System.out.println(a.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }

}
