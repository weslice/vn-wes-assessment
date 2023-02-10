package com.visualnuts.resource;

public abstract class PrintableResource {

    private PrintableResource next;

    public static PrintableResource link(PrintableResource first, PrintableResource... chain) {
        PrintableResource head = first;
        for(PrintableResource nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract String print(String current, int value);

    protected String printNext(String current, int value) {
        if (next == null) {
            return current;
        }
        return next.print(current, value);
    }

}



