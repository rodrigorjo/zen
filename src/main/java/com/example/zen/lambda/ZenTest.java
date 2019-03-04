package com.example.zen.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ZenTest {

    public static void main(String[] args){
        ZenTest z = new ZenTest();
      //  z.calculate();

        Function<List<Test>, List<Test>> f = z.filter((Test te) -> te.getWeight() > 10 );

        z.consumeList().accept
                (z.filter((Test te) -> te.getWeight() > 10 ).apply
                        (z.createList())
        );

    }

    public void calculate(){


        Test t = new Test("Dogen", 0);
        t.setName("Dogen");

        t.method((a, b) -> Long.valueOf( a + b), 3,5);



        Function<Test, String> f = Test::getName;

        System.out.println(f.apply(t));

        CreateInterface<Test> createInterface = t::createTest;

        Test t2 = createInterface.create(500);
        System.out.println(t2.getName()+t2.getWeight());
    }

    private Supplier<Test> ge(String name, int w) {
        return () -> new Test(name, w);
    }

    public Function<List<Test>, List<Test>> filter(Predicate<Test> predicate){
        return (List<Test> lista) -> {
            List<Test> result = new ArrayList<>();
            for (Test teste: lista) {
                if(predicate.test(teste)) {
                    result.add(teste);
                }
            }
            return result;
        };
    }

    public Consumer<List<Test>> consumeList(){
        return (lista) -> {
            for (Test teste : lista) {
                System.out.println(teste.getName());
            }
        };
    }

    private List<Test> createList(){
        List<Test> result = new ArrayList<>();
        result.add(new Test("za", 10));
        result.add(new Test("be", 80));
        result.add(new Test("ta", 50));
        return result;
    }
}
