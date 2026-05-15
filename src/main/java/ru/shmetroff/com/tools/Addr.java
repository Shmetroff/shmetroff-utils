package ru.shmetroff.com.tools;

public class Addr {
    public static int get(Object o) {
        return System.identityHashCode(o);
    }

    public static String hex(Object o) {
        int addr = System.identityHashCode(o);
        return String.format("%08x", addr);
    }
}
