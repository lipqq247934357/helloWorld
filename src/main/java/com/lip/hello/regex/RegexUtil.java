package com.lip.hello.regex;

import java.util.regex.Pattern;

public class RegexUtil {

    public static String phoneIntervalAddStar(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static boolean testPhone(String phone) {
        return Pattern.matches("1[3|4|5|6|7|8]\\d{9}", phone);
    }

    public static boolean testEmail(String email) {
        return false;
    }

    public static boolean testIdCard(String idCard) {
        return false;
    }

    public static void main(String[] args) {
        show(testPhone("18903592838"));
    }

    public static void show(Object o) {
        System.out.println(o);
    }
}
