package ru.krotarnya.leetcode.problem;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0480.Solution;

public class Test0480 {
    private final Solution solution = new Solution();

    @ValueSource(strings = {
            "1,3,-1,-3,5,3,6,7;3;1,-1,-1,3,5,6",
            "1,2,3,4,2,3,1,4,2;3;2,3,3,3,2,3,2",
            "1,2,3,4,2,3,1,4,2;1;1,2,3,4,2,3,1,4,2",
            "10,8,6,4,2,0;2;9,7,5,3,1",
            "-1,-1,1,-1,-1,-1,1,1,1,1,-1,1,-1;3;-1,-1,-1,-1,-1,1,1,1,1,1,-1",
    })
    @ParameterizedTest
    void test(String data) {
        String[] dataParts = data.split(";");
        int[] input = Arrays.stream(dataParts[0].split(","))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();
        int width = Integer.parseInt(dataParts[1]);
        double[] expected = Arrays.stream(dataParts[2].split(","))
                .filter(s -> !s.isBlank())
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] result = solution.medianSlidingWindow(input, width);

        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(expected, result, 0.1);
    }
}
