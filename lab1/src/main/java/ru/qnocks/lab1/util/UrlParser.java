package ru.qnocks.lab1.util;

import javax.servlet.http.HttpServletRequest;

public class UrlParser {
    public static long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        return Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
    }
}
