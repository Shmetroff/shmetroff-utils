package ru.shmetroff.com.tools;

public class Str {
    public static String repeat(String s, int count) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < count) {
            sb.append(s);
        }
        return sb.toString();
    }
}
