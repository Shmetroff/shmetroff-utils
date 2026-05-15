package ru.shmetroff.com.http;

import javax.servlet.http.Cookie;
import java.util.Optional;

public class Cookies {
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
