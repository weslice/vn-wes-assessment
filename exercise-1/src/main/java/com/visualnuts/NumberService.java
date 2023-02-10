package com.visualnuts;

import com.visualnuts.resource.PrintableResource;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class NumberService {

    private PrintableResource printableResourceChain;

    private final PrintStream out;

    NumberService(PrintableResource printableResource, PrintStream out) {
        this.printableResourceChain = printableResource;
        this.out = out;
    }

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
                    .forEach(out::println);
        }
    }

}
