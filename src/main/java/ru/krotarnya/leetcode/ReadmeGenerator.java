package ru.krotarnya.leetcode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.reflections.Reflections;

public class ReadmeGenerator {
    private static final String PACKAGE_PREFIX = "ru.krotarnya.leetcode";
    
    private List<Problem> getProblems() {
        Reflections reflections = new Reflections(PACKAGE_PREFIX);
        return reflections.getTypesAnnotatedWith(Problem.class).stream()
                .map(clazz-> clazz.getAnnotation(Problem.class))
                .sorted(Comparator.comparingInt(Problem::id))
                .collect(Collectors.toList());
    }
    
    private String problemsToMarkdown(List<Problem> problems) {
        StringBuilder builder = new StringBuilder();
        problems.forEach(problem -> builder.append(problemToMarkdown(problem)));
        return builder.toString();
    }

    private String problemToMarkdown(Problem problem) {
        return String.format("* [Problem #%d](https://leetcode.com/problems/%s/)\n", problem.id(), problem.name());
    }
    
    private String generateReadme() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = Objects.requireNonNull(classloader.getResourceAsStream("readme_template"));
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        return reader.lines()
                .map(line -> line.equals("%PROBLEMS%") ? problemsToMarkdown(getProblems()) : line)
                .collect(Collectors.joining("\n"));
    }
    

    
    public static void main(String[] args) {
        System.out.println(new ReadmeGenerator().generateReadme());
    }
}
