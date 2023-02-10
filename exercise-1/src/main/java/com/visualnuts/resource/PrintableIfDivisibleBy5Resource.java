package com.visualnuts.resource;

public class PrintableIfDivisibleBy5Resource extends PrintableResource {

    private static final String NUTS = "Nuts";

    @Override
    public String print(String current, int value) {
        if (value % 5 == 0) {
            return NUTS + printNext(current, value);
        }
        return printNext(current, value);
    }
}
