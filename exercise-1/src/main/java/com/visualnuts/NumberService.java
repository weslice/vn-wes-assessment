package com.visualnuts;

import com.visualnuts.resource.PrintableIfDivisibleBy3Resource;
import com.visualnuts.resource.PrintableIfDivisibleBy5Resource;
import com.visualnuts.resource.PrintableResource;

import java.util.stream.IntStream;

public class NumberService {

    private static final PrintableResource printableResourceChain = PrintableResource.link(
            new PrintableIfDivisibleBy3Resource(), new PrintableIfDivisibleBy5Resource()
    );

    public void printNumber(IntStream valuesToPrint) {
        if (valuesToPrint != null) {
            valuesToPrint.mapToObj(value -> {
                        var result = printableResourceChain.print("", value);

                        // In case no value has been applied in the chain, print the original value instead.
                        if(result.isBlank()) {
                            return String.valueOf(value);
                        }

                        return result;
                    })
                    .forEach(System.out::println);
        }
    }

}
