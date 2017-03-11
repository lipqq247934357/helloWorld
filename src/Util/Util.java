package Util;

public class Util {

    //将long类型时间（yyyymmddHHMMssSSS）转换成
    public static String parse(long time) {
        String timeStr = time + "";
        return timeStr.replaceAll("(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{3})",
            "$1年$2月$3日$4:$5:$6");
    }

    //将身份证加星
    public static String maskIDCard(String idCard) {
        StringBuffer sb = new StringBuffer();
        sb.append(idCard.substring(0, 4));
        if (idCard.length() == 18) {
            sb.append("***********");
        } else {//此处包括15位和非18,15位
            sb.append("********");
        }
        sb.append(idCard.subSequence(idCard.length() - 3, idCard.length()));
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(Util.maskIDCard("142731199301095733"));

    }
}
