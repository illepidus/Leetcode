package ru.krotarnya.leetcode.problem.p0008;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

/**
 * Implement the myAtoi(string s) function, which converts a string 
 * to a 32-bit signed integer (similar to C/C++'s atoi function).
 */
@Problem(id = 8, name = "string-to-integer-atoi", complexity = Complexity.MEDIUM)
public class Solution {
    public static int myAtoi(String s) {
        Matcher matcher = Pattern.compile("^\\s*(([-+])?\\d+).*$").matcher(s);
        if (!matcher.matches()) return 0;
        
        boolean positive = (matcher.group(2) == null || matcher.group(2).equals("+"));
        int ret;
        try {
            ret = Integer.parseInt(matcher.group(1));
        }
        catch (NumberFormatException ignored) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
        }
        return ret;
    }
}
