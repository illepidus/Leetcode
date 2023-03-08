package ru.krotarnya.leetcode.util;

public class StringUtils {
    public static String shorten(String subject, int maxLength) {
        if (subject.length() < 3) return subject;
        
        return subject.length() > maxLength
                ? subject.substring(0, maxLength - 3) + "..."
                : subject;
    }
}