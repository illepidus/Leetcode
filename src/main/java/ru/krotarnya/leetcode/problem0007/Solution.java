package ru.krotarnya.leetcode.problem0007;

/**
 * @author ivblinov
 */
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