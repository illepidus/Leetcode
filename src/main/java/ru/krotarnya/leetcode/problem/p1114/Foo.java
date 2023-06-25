package ru.krotarnya.leetcode.problem.p1114;

import java.util.concurrent.CyclicBarrier;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

@Problem(id = 1114, name = "print-in-order", className = "Foo", complexity = Complexity.EASY)
public class Foo {
    private final CyclicBarrier firstBarrier;
    private final CyclicBarrier secondBarrier;
    public Foo() {
        firstBarrier = new CyclicBarrier(2);
        secondBarrier = new CyclicBarrier(2);
    }
    public void first(Runnable r) {
        try {
            r.run();
            firstBarrier.await();
        } catch (Exception ignored) {}
    }
    public void second(Runnable r) {
        try {
            firstBarrier.await();
            r.run();
            secondBarrier.await();        
        } catch (Exception ignored) {}
    }
    public void third(Runnable r) {
        try {
            secondBarrier.await();
            r.run();
        } catch (Exception ignored) {}
    }
}
