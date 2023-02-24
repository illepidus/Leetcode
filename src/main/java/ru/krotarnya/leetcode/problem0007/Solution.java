package ru.krotarnya.leetcode.problem0007;

import ru.krotarnya.leetcode.Problem;

/**
 * <p>Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.</p>
 * <p>Assume the environment does not allow you to store 64-bit integers (signed or unsigned).</p>
 */
@Problem(id = 7, name = "reverse-integer")
class Solution {
    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            x = -x;
            negative = true;
        }
        
        String s = String.valueOf(x);
        s = new StringBuilder(s).reverse().toString();
        
        try {
            return (negative ? -1 : 1) * Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
}