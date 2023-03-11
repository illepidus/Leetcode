package ru.krotarnya.leetcode.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {
    public static void write(Path path, String content) {
        try (PrintWriter printWriter = new PrintWriter(path.toFile())) {
            printWriter.print(content);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed saving readme");
        }
    }
    
    public static List<String> readToList(Path path) {
        try {
            return readToList(path.toUri().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to read from " + path, e);
        }
    }

    private static List<String> readToList(URL url) {
        try {
            return new BufferedReader(new InputStreamReader(url.openStream())).lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from " + url, e);
        }
    }
}
