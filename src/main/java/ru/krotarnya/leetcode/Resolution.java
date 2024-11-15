package ru.krotarnya.leetcode;


public enum Resolution {
    FAIR("Solution totally satisfy constraints"),
    PASS("Solution is accepted by leetcode, but breaks some unchecked constraints"),
    TIMEOUT("Not accepted by leetcode due to timeout"),
    PARTIAL("Solution passes some test, but not all"),
    NONE("There is no solution");

    private final String description;

    Resolution(String description) {
        this.description = description;
    }

    String description() {
        return description;
    }
}
