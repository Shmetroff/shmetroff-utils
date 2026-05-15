package ru.shmetroff.com.tools;

public class StopWatch {
    private String name;
    private boolean debug;
    private long beg;

    public void start(String name, boolean debug) {
        this.name = name;
        this.debug = debug;
        if (debug) System.out.println("=== " + name + " ===");
        beg = System.currentTimeMillis();
    }

    public void start(String name) {
        start(name, false);
    }

    public void stop() {
        long end = System.currentTimeMillis();
        System.out.println(name + ": " + (end - beg) + " ms");
        if (debug) System.out.println();
    }
}
