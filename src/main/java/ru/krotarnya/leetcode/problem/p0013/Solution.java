package ru.krotarnya.leetcode.problem.p0013;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

/**
 * <p>Given a roman numeral, convert it to an integer.</p>
 * <p>s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')</p>
 * <p>It is guaranteed that s is a valid roman numeral in the range [1, 3999]</p>
 */

@Problem(id = 13, name = "roman-to-integer", complexity = Complexity.MEDIUM)
public class Solution {
    private static final Map<Character, Integer> ROMAN_MAP = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );
    
    public static int romanToInt(String s) {
        return romanToInt1(s);
    }
    
    public static int romanToInt1(String s) {
        char[] chars = s.toCharArray();
        int out = 0;
        int max = 0;
        
        for (int i = s.length() - 1 ; i >= 0; i--) {
            int x = ROMAN_MAP.get(chars[i]);

            if (x >= max) {
                out += x;
                max = x;
            }
            else out -= x;
        }
        
        return out;
    }
    
    public static int romanToInt2(String s) {
        AtomicInteger out = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(0);

        new StringBuilder(s).reverse().chars()
                .mapToObj(c -> Character.valueOf((char) c).toString())
                .map(Roman::value)
                .forEach(i -> {
                    if (i >= max.get()) {
                        out.addAndGet(i);
                        max.set(i);
                    }
                    else {
                        out.addAndGet(-i);
                    }
                });
        
        return out.get();
    }

    @SuppressWarnings("UnusedDeclaration")
    private enum Roman {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        private final int value;

        Roman(int value) {
            this.value = value;
        }
        
        public static int value(String s) {
            return Roman.valueOf(s).value;
        }
    }
}
