package ru.shmetroff.com.tools;

/**
 * Helper class for keeping track of execution time
 *
 * @author Alex Alejandro Shmetroff
 * @date 15.05.2026
 */
public class StopWatch {
    private String name;
    private boolean debug;
    private long beg;

    /**
     * Starts StopWatch, set name & debug flag (prints header with name if debug is true)
     *
     * @param name  Name of StopWatch
     * @param debug Flag for print header & new line after stop
     */
    public void start(String name, boolean debug) {
        this.name = name;
        this.debug = debug;
        if (debug) System.out.println("=== " + name + " ===");
        beg = System.currentTimeMillis();
    }

    /**
     * Like above but debug always is false (never prints header)
     *
     * @param name Name of StopWatch
     */
    public void start(String name) {
        start(name, false);
    }

    /**
     * Stops StopWatch, print time in MS with name.
     * <p>
     * If debug is true - prints new line at the very end after everything.
     */
    public void stop() {
        long end = System.currentTimeMillis();
        System.out.println(name + ": " + (end - beg) + " ms");
        if (debug) System.out.println();
    }
}
