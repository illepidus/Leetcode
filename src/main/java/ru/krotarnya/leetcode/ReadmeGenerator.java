package ru.krotarnya.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import static ru.krotarnya.leetcode.util.FileUtils.readToList;
import static ru.krotarnya.leetcode.util.FileUtils.write;
import static ru.krotarnya.leetcode.util.StringUtils.shorten;

public class ReadmeGenerator {
    private final PathProvider pathProvider;
    private final URLProvider urlProvider;
    private static final int MAX_PROBLEM_CHARACTERS_TO_DISPLAY = 30;

    public ReadmeGenerator(PathProvider pathProvider, URLProvider urlProvider) {
        this.pathProvider = pathProvider;
        this.urlProvider = urlProvider;
    }

    private List<Problem> getProblems() {
        Reflections reflections = new Reflections(Problem.class.getPackage().getName());
        return reflections.getTypesAnnotatedWith(Problem.class).stream()
                .map(clazz -> clazz.getAnnotation(Problem.class))
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
                                <td><a href="%s">%s</a></td>
                                <td>%s</td>
                                <td><a href="%s">Leetcode</a></td>
                                <td title="%s">%s</td>
                            </tr>
                        """,
                problem.id(),
                urlProvider.gitHub(problem.id(), problem.className()),
                shorten(problem.name(), MAX_PROBLEM_CHARACTERS_TO_DISPLAY),
                problem.complexity(),
                urlProvider.leetcode(problem.name()),
                problem.resolution().description(),
                problem.resolution());
    }

    public Readme generateReadme() {
        return new Readme(
                readToList(pathProvider.readmeTemplate())
                        .stream()
                        .map(line -> line.equals("%PROBLEMS%")
                                ? problemsToHtmlRows(getProblems())
                                : line
                        )
                        .collect(Collectors.joining("\n"))
        );
    }

    public static void main(String[] args) {
        new ReadmeGenerator(new PathProvider(), new URLProvider())
                .generateReadme()
                .save();
    }

    private class Readme {
        private final String content;

        private Readme(String content) {
            this.content = content;
        }

        private void save() {
            write(pathProvider.readme(), content);
        }
    }
}
