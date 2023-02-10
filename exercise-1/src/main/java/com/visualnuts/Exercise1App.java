package com.visualnuts;

import java.util.stream.IntStream;

public class Exercise1App {


    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
        NumberService numberService = new NumberService();
        IntStream intStream = IntStream.rangeClosed(RANGE_START, RANGE_END);
        numberService.printNumber(intStream);
    }
}
