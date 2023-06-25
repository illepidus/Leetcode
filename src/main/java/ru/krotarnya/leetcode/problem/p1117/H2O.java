package ru.krotarnya.leetcode.problem.p1117;

import java.util.concurrent.Semaphore;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

@Problem(id = 1117, name = "building-h2o", complexity = Complexity.MEDIUM)
public class H2O {
    private final Semaphore oSemaphore = new Semaphore(1);
    private final Semaphore hSemaphore = new Semaphore(2);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire(1);
        releaseHydrogen.run();
        oSemaphore.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire(2);
        releaseOxygen.run();
        hSemaphore.release(2);
    }
}
