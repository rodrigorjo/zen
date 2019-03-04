package com.example.zen.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Test implements Callable<Boolean> {

    String name;
    int weight;

    public Test(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Test createTest(int weight){
        return new Test(null, weight);
    }

    public void method(CalculateInterface calculate, int obj1, int obj2){
        System.out.println(calculate.calculate(obj1, obj2));
    }

    public void method(BiFunction<Integer, Integer, Integer> function, Integer obj1, Integer obj2){
        System.out.println(function.apply(obj1, obj2));
    }

    public void consume(Consumer consumer){
        consumer.accept(getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public Boolean call() throws Exception {
        return this.weight > 10;
    }

}
