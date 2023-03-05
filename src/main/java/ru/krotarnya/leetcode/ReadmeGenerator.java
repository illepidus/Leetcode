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
    
    private String problemsToHtmlTable(List<Problem> problems) {
        StringBuilder builder = new StringBuilder();
        builder.append("""
                <table>
                    <tr>
                        <td>Id</td>
                        <td>Name</td>
                        <td>Complexity</td>
                        <td>Solution</td>
                        <td>Resolution</td>
                    </tr>
                """);
        problems.forEach(problem -> builder.append(problemToHtmlRow(problem)));
        builder.append("</table>");
        return builder.toString();
    }

    private String problemToHtmlRow(Problem problem) {
        return String.format(
                """
                    <tr>
                        <td>%d</td>
                        <td><a href="https://leetcode.com/problems/%s/">%s</a></td>
                        <td>%s</td>
                        <td><a href="%s">SOLUTION</a></td>
                        <td title="%s">%s</td>
                    </tr>
                """, problem.id(), problem.name(), problem.name(), problem.complexity(), "", problem.resolution().description(), problem.resolution());
    }
    
    private String generateReadme() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = Objects.requireNonNull(classloader.getResourceAsStream("readme_template"));
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        return reader.lines()
                .map(line -> line.equals("%PROBLEMS%") ? problemsToHtmlTable(getProblems()) : line)
                .collect(Collectors.joining("\n"));
    }
    
    public static void main(String[] args) {
        System.out.println(new ReadmeGenerator().generateReadme());
    }
}
