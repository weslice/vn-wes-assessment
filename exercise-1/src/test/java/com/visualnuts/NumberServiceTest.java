package com.visualnuts;

import com.visualnuts.resource.PrintableResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class NumberServiceTest {


    private final PrintStream out = mock(PrintStream.class);

    private final PrintableResource printableResource = mock(PrintableResource.class);

    private final NumberService numberService = new NumberService(printableResource, out);



    @Test
    @DisplayName("Should print 1 times")
    void printNumber1() {
        when(printableResource.print(any(), anyInt())).thenReturn("1");

        numberService.printNumber(IntStream.rangeClosed(1,1));

        Mockito.verify(out, times(1)).println("1");
    }

    @Test
    @DisplayName("Sound print 100 times")
    void printOut100Times() {
        when(printableResource.print(any(), anyInt())).thenReturn("");

        numberService.printNumber(IntStream.rangeClosed(1,100));

        Mockito.verify(out, times(100)).println(any(String.class));
    }

    @Test
    @DisplayName("Should print a mock value")
    void printNumberPrintAMockedValue() {
        when(printableResource.print(any(), anyInt())).thenReturn("Mock");

        numberService.printNumber(IntStream.rangeClosed(1,1));

        Mockito.verify(out, times(1)).println("Mock");
    }

    @Test
    @DisplayName("Given a null parameter to print, do nothing")
    void receiveNullInputStreamDoNothing() {
        when(printableResource.print(any(), anyInt())).thenReturn("");

        numberService.printNumber(null);

        Mockito.verify(out, times(0)).println(any(String.class));
    }

}
