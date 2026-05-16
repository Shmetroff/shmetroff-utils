package ru.shmetroff.com.tools;

/**
 * Helper class for work with hash code & adress
 * @author Alex Alejandro Shmetroff
 * @date 15.05.2026
 */
public class Addr {
    /**
     * Returns hash code of the Object (addres in RAM)
     * @param o
     *        Object which hash code (addres) needed
     * @return Hash code (addres)
     */
    public static int get(Object o) {
        return System.identityHashCode(o);
    }

    /**
     * Returns hash code of the Object (addres in RAM) in a 0x hex format
     * @param o
     *        Object which hash code (addres) needed
     * @return Hash code (addres) in a 0x hex format
     */
    public static String hex(Object o) {
        int addr = System.identityHashCode(o);
        return String.format("%08x", addr);
    }
}
