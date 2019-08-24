package com.cdleaf.util;

public class StringUtil {
    private static char[] codes = new char[]{'A','B'};

    public static String shorten(String str, int len) {
        if(str == null){
            return "";
        }

        if(str.length() < len + 3){
            return str;
        }

        return str.substring(len) + "...";
    }

    public static String encodeId(Long id){

        return "";
    }
}
