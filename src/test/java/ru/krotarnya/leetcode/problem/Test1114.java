package ru.krotarnya.leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.krotarnya.leetcode.problem.p1114.Foo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1114 {
    private static final Foo FOO = new Foo();
    private static final List<Integer> RESULT = new ArrayList<>();
    private static final Map<Integer, Runnable> MAP = Map.of(
            1, () -> FOO.first(() -> RESULT.add(1)),
            2, () -> FOO.second(() -> RESULT.add(2)),
            3, () -> FOO.third(() -> RESULT.add(3))
    );

    @CsvSource({"1, 2, 3", "1, 3, 2", "2, 1, 3", "2, 3, 1", "3, 1, 2", "3, 2, 1"})
    @ParameterizedTest
    void test(int _1, int _2, int _3) throws InterruptedException {
        RESULT.clear();
        List.of(_1, _2, _3).forEach(i -> new Thread(MAP.get(i)).start());
        Thread.sleep(10);
        assertEquals(List.of(1, 2, 3), RESULT);
    }
}
