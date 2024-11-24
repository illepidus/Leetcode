package ru.krotarnya.leetcode.problem.p0038;

import java.util.ArrayList;
import java.util.List;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

@Problem(id = 38, name = "count-and-say", complexity = Complexity.MEDIUM, resolution = Resolution.FAIR)
public class Solution {
    private static final List<String> RESULTS = new ArrayList<>(List.of("1"));
    private final static int MIN_INPUT_CONSTRICTION = 1;
    private final static int MAX_INPUT_CONSTRICTION = 30;

    public synchronized String countAndSay(int n) {
        if ((n < MIN_INPUT_CONSTRICTION) || (n > MAX_INPUT_CONSTRICTION)) throw new IllegalArgumentException();
        if (n <= RESULTS.size()) return RESULTS.get(n - 1);
        return countAndSay(RESULTS.getLast(), RESULTS.size(), n);
    }

    private String countAndSay(String input, int i, int n) {
        if (i == n) return input;
        return countAndSay(countAndSay(input), ++i, n);
    }

    private String countAndSay(String input) {
        StringBuilder result = new StringBuilder();
        char c = input.charAt(0);
        int n = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == c)
                n++;
            else {
                result.append(Integer.valueOf(n)).append(c);
                c = input.charAt(i);
                n = 1;
            }
        }
        result.append(Integer.valueOf(n)).append(c);
        RESULTS.add(result.toString());
        return result.toString();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + RESULTS.size() + "]";
    }
}
