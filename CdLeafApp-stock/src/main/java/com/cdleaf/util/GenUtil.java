package com.cdleaf.util;

import java.util.UUID;

public class GenUtil {

    public static void main(String[] args) {
        System.out.println(genUUID());
    }

    public static String genUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
