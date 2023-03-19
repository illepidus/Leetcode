package ru.krotarnya.leetcode;

import java.net.MalformedURLException;
import java.net.URL;

public class URLProvider {
    private static final String LEETCODE_PROBLEM_TEMPLATE = "https://leetcode.com/problems/%s/";
    private static final String GITHUB_PROBLEM_TEMPLATE = 
            "https://github.com/illepidus/Leetcode/blob/master/src/main/java/ru/krotarnya/leetcode/problem/p%04d/%s.java";
    
    public URL leetcode(String problemName) {
        return urlOf(String.format(LEETCODE_PROBLEM_TEMPLATE, problemName));
    }

    public URL gitHub(int problemId, String className) {
        return urlOf(String.format(GITHUB_PROBLEM_TEMPLATE, problemId, className));
    }
    
    private URL urlOf(String path) {
        try {
            return new URL(path);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed url", e);
        }
    }
}
