package ru.krotarnya.leetcode.problem.p0038;

import java.util.ArrayList;
import java.util.List;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

@Problem(id = 38, name = "count-and-say", complexity = Complexity.MEDIUM)
public class Solution {
    private final static List<String> RESULTS = new ArrayList<>(List.of("1"));
    
    public String countAndSay(int n) {
        if (n <= RESULTS.size()) return RESULTS.get(n - 1);
        return countAndSay(RESULTS.get(RESULTS.size() - 1), RESULTS.size(), n);
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
}