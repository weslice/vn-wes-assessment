package com.visualnuts;

import com.visualnuts.resource.PrintableIfDivisibleBy3Resource;
import com.visualnuts.resource.PrintableIfDivisibleBy5Resource;
import com.visualnuts.resource.PrintableResource;

import java.util.stream.IntStream;

public class Exercise1App {


    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    private static final PrintableResource printableResourceChain = PrintableResource.link(
            new PrintableIfDivisibleBy3Resource(), new PrintableIfDivisibleBy5Resource()
    );


    public static void main(String[] args) {
        var outPut = System.out;
        var numberService = new NumberService(printableResourceChain, outPut);

        IntStream intStream = IntStream.rangeClosed(RANGE_START, RANGE_END);
        numberService.printNumber(intStream);
        outPut.close();
    }
}
