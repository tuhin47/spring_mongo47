package com.tuhin47.mongo.util;

public class KeyGenerator {
    public static String getKey(String value) {
        return value.replaceAll(" ", "_").toLowerCase();
    }
}
