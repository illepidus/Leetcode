package ru.krotarnya.leetcode.problem;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0121.Solution;

public class Test0121 {
    private final Solution stock = new Solution();

    @ValueSource(strings = {
            "7,1,5,3,6,4;5",
            "7,6,4,3,1;0",
    })
    @ParameterizedTest
    void test(String data) {
        String[] dataParts = data.split(";");
        int[] input = Arrays.stream(dataParts[0].split(","))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();
        int expected = Integer.parseInt(dataParts[1]);
        Assertions.assertEquals(expected, stock.maxProfit(input));
    }
}
