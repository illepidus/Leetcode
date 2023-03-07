package ru.krotarnya.leetcode;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.reflections.Reflections;

public class ReadmeGenerator {
    private static final String PACKAGE_PREFIX = "ru.krotarnya.leetcode";
    private static final int MAX_PROBLEM_CHARACTERS_TO_DISPLAY = 30;
    
    private List<Problem> getProblems() {
        Reflections reflections = new Reflections(PACKAGE_PREFIX);
        return reflections.getTypesAnnotatedWith(Problem.class).stream()
                .map(clazz-> clazz.getAnnotation(Problem.class))
                .sorted(Comparator.comparingInt(Problem::id))
                .collect(Collectors.toList());
    }
    
    private String problemsToHtmlRows(List<Problem> problems) {
        StringBuilder builder = new StringBuilder();
        problems.forEach(problem -> builder.append(problemToHtmlRow(problem)));
        return builder.toString();
    }

    private String problemToHtmlRow(Problem problem) {
        return String.format(
                """
                    <tr>
                        <td>%d</td>
                        <td><a href="https://github.com/illepidus/Leetcode/blob/master/src/main/java/ru/krotarnya/leetcode/problem/p%s/Solution.java">%s</a></td>
                        <td>%s</td>
                        <td><a href="https://leetcode.com/problems/%s/">Leetcode</a></td>
                        <td title="%s">%s</td>
                    </tr>
                """, 
                problem.id(),
                String.format("%04d", problem.id()), problem.name().length() > MAX_PROBLEM_CHARACTERS_TO_DISPLAY
                        ? problem.name().substring(0, MAX_PROBLEM_CHARACTERS_TO_DISPLAY) + "..." 
                        : problem.name(),
                problem.complexity(),
                problem.name(),
                problem.resolution().description(), problem.resolution());
    }
    
    private Readme generateReadme() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = Objects.requireNonNull(classloader.getResourceAsStream("readme_template"));
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        return new Readme(reader.lines()
                .map(line -> line.equals("%PROBLEMS%") ? problemsToHtmlRows(getProblems()) : line)
                .collect(Collectors.joining("\n")));
    }
    
    public static void main(String[] args) {
        new ReadmeGenerator().generateReadme().save();
    }

    private record Readme(String content) {
        public void save() {
            save(System.getProperty("user.dir") + "/README.MD");
        }
        private void save(String fileName) {
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(content);
                printWriter.close();
            }
            catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }
}
