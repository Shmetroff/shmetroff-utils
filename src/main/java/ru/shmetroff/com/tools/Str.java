package ru.shmetroff.com.tools;

/**
 * Helper class for work with some String function (only in Java 8 or earlier)
 *
 * @author Alex Alejandro Shmetroff
 * @date 15.05.2026
 */
public class Str {
    /**
     * Repeats specified String specified times
     *
     * @param s
     *        String needed to repeat
     * @param count
     *        Times to repeat
     * @return Repeated String
     */
    public static String repeat(String s, int count) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < count) {
            sb.append(s);
        }
        return sb.toString();
    }
}
