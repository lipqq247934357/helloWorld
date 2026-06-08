package com.lip.hello.basics.util;

public final class StringUtil {

    private StringUtil() {
    }

    public static String parse(long time) {
        String timeStr = time + "";
        return timeStr.replaceAll(
            "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{3})",
            "$1年$2月$3日$4:$5:$6");
    }

    public static String maskIDCard(String idCard) {
        StringBuilder sb = new StringBuilder();
        sb.append(idCard, 0, 4);
        sb.append(idCard.length() == 18 ? "***********" : "********");
        sb.append(idCard.substring(idCard.length() - 3));
        return sb.toString();
    }
}
