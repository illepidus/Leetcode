package ru.krotarnya.leetcode.problem;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0704.Solution;

public class Test0704 {
    private final Solution binarySearcher = new Solution();

    @ValueSource(strings = {
            ";0;-1",
            "1,2,3;2;1",
            "1;1;0",
            "-1,0,3,5,9,12;9;4",
            "-1,0,3,5,9,12;-1;0",
            "-1,0,3,5,9,12;12;5",
            "-1,0,3,5,9,12;2;-1",
            "-1,0,3,5,9,12;0;1",
            "-1,0,3,5,9;2;-1",
    })
    @ParameterizedTest
    void test(String data) {
        String[] dataParts = data.split(";");
        int[] input = Arrays.stream(dataParts[0].split(","))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(dataParts[1]);
        int expected = Integer.parseInt(dataParts[2]);
        Assertions.assertEquals(expected, binarySearcher.search(input, target));
    }
}
