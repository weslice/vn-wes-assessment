package com.visualnuts;

import com.visualnuts.resource.PrintableIfDivisibleBy3Resource;
import com.visualnuts.resource.PrintableIfDivisibleBy5Resource;
import com.visualnuts.resource.PrintableResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class NumberServiceTest {

    private PrintableResource printableResourceChain;
    private IntStream intStream = IntStream.rangeClosed(1, 100);
    private IntStream intStream500 = IntStream.rangeClosed(1, 500);

    NumberServiceTest() {
        this.printableResourceChain = PrintableResource.link(
                new PrintableIfDivisibleBy3Resource(),
                new PrintableIfDivisibleBy5Resource());
    }

    @Test
    @DisplayName("Should do the default - print number from 1 to 100, " +
            "when the number is divided by 3 print Visual, when divided by 5 print Nut, " +
            "when divided by both print Visual Nuts")
    void printNumber() {
        new NumberService().printNumber(intStream);
    }

    @Test
    @DisplayName("Should print number from 1 to 500 - when receive a limit range parameter")
    public void numberPrinterFrom1To500() {
        new NumberService().printNumber(intStream500);
    }

    @Test
    @DisplayName("Given a null parameter to print, do nothing")
    public void receiveNullInputStreamDoNothing() {
        new NumberService().printNumber(null);
    }

}
