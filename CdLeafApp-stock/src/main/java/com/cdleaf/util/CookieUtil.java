package com.cdleaf.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static final String USER_COOKIE_NAME = "sessionid";

    public static final int DELETE_EXIT = -1;
    private static final int SECOND = 1;
    public static final int MINUTE = 60 * SECOND;
    public static final int HOUR = 60 * MINUTE;
    public static final int DAY = 24 * HOUR;
    public static final int WEEK = 7 * DAY;
    public static final int MONTH = 31 * DAY;
    public static final int YEAR = 365 * DAY;
    public static final int FOREVER = 10 * YEAR;

    public static String getCookie(HttpServletRequest request, String cookieName) {
        if (request == null || cookieName == null) return null;

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }

        return null;
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String value, int time) {
        if (response == null || cookieName == null) return;

        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        cookie.setMaxAge(time);
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse response, String cookieName) {
        if (response == null || cookieName == null) return;

        Cookie cookie = new Cookie(cookieName, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
