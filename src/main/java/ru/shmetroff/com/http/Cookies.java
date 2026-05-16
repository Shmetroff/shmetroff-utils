package ru.shmetroff.com.http;

import javax.servlet.http.Cookie;
import java.util.Optional;

/**
 * Helper class for work with Cookie
 * @author Alex Alejandro Shmetroff
 * @date 15.05.2026
 */
public class Cookies {
    /**
     * Prints all Cookie attributes in a human-friendly format
     * @param c
     *        Cookie to print
     * @return String with the Cookie in a human-friendly format
     */
    public static String print(Cookie c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c.getName()).append(" = '").append(c.getValue()).append("' [");
        sb.append("domain: '").append(Optional.ofNullable(c.getDomain()).orElse("")).append("', ");
        sb.append("path: '").append(Optional.ofNullable(c.getPath()).orElse("")).append("', ");
        sb.append("maxAge: ").append(c.getMaxAge()).append(", ");
        sb.append("secure: ").append(c.getSecure()).append(", ");
        sb.append("httpOnly: ").append(c.isHttpOnly()).append(", ");
        sb.append("version: ").append(c.getVersion()).append(", ");
        sb.append("comment: '").append(c.getComment()).append("']");
        return sb.toString();
    }
}
