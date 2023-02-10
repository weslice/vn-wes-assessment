package com.visualnuts.resource;

public class PrintableIfDivisibleBy3Resource extends PrintableResource {

    private static final String VISUAL = "Visual";

    @Override
    public String print(String current, int value) {
        if (value % 3 == 0) {
            return VISUAL + printNext(current, value);
        }
        return printNext(current, value);
    }
}
