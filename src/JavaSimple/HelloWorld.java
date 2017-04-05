package JavaSimple;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.Test;

import com.twotiger.util.DateUtil;

public class HelloWorld {

    @Test
    public void hehe() {
        for (int i = 10; i < 22; i++) {
            System.out
                .println("INSERT INTO `xiaobai`.`activity_user_join` (`userId`, `activityId`, `nid`, `value`, `type`, `source`, `status`, `invalidTime`, `ctime`, `utime`) VALUES ( '71', '1', 'daily_lottery_1', '0."
                         + i
                         + "', '0', '每日抽奖', '2', '20161106101230060', '201611031012"
                         + i
                         + "861', '20161106101500159');");
        }
        for (int i = 22; i < 32; i++) {
            System.out
                .println("INSERT INTO `xiaobai`.`activity_user_join` (`userId`, `activityId`, `nid`, `value`, `type`, `source`, `status`, `invalidTime`, `ctime`, `utime`) VALUES ( '71', '1', 'daily_lottery_1', '0."
                         + i
                         + "', '0', '每日抽奖', '2', '20161106101230060', '201610031012"
                         + i
                         + "861', '20161106101500159');");
        }
        for (int i = 32; i < 35; i++) {
            System.out
                .println("INSERT INTO `xiaobai`.`activity_user_join` (`userId`, `activityId`, `nid`, `value`, `type`, `source`, `status`, `invalidTime`, `ctime`, `utime`) VALUES ( '71', '1', 'daily_lottery_1', '0."
                         + i
                         + "', '0', '每日抽奖', '2', '20161106101230060', '201612031012"
                         + i
                         + "861', '20161106101500159');");
        }
    }

    @Test
    public void hehe2() {

        System.out
            .println("123456788828838585531".replaceFirst("(\\d{4})\\d+(\\d{4})", "$1****$2"));

        System.out.println("-1".equals(null));

        System.out.println(Pattern.matches("^\\d{6}$", "100000"));

        System.out.println("1sdsss".length());
    }

    @Test
    public void hehex() {

        if (!Pattern.matches(".", null)) {
            System.out.println("aaaaaaa");
        }
    }

    @Test
    public void hehex2() {

        String str = null;
        if (str == null) {
            System.out.println();
        }

    }

    @Test
    public void hehe3() {

        String[][] info = { { "0.2", "3" }, { "5", "2", "500" }, { "5", "1" }, { "8", "1" } };

        String[][] str = new String[][] { info[0], info[1] };

        System.out.println(str);
    }

    @Test
    public void test1() {

        long a = 1000000011;
        System.out.println(a / 1000);

        double[][] quan = { { 0.2, 2 }, { 0.4, 2 }, { 5, 0 }, { 50, 1 }, { 75, 1 }, { 20, 0 },
                           { 0.6, 2 }, { 0.8, 2 } };//没有100元现金红包
        System.out.println((int) quan[1][1]);

    }

    @Test
    public void test2() {

        int[] a = { 1, 2, 3, 4 };
        //数组没有直接的删除某个元素的方法，需要自己写
    }

    @Test
    public void test3() {

        int a = 9;

        do {
            a++;
        } while (a == 10);
        System.out.println(a);
    }

    @Test
    public void test4() {

        for (int i = 0; i < 100; i++) {
            System.out.println(((int) Math.floor(Math.random() * 3) + 3) > 6);
        }
    }

    @Test
    public void test5() {

        for (int i = 1; i <= 14; i++) {
            System.out.println("insert into act_record values(" + (i + 144) + ",'act_16_9_1_" + i
                               + "',100,0,2,20160831235959000,20160831235959000);");
        }
        System.out.println(144 + 14);
    }

    @Test
    public void test6() {

        System.out.println("aaa\t" + "aaaaaaa");
    }

    @Test
    public void test8() {

        Calendar.getInstance().getTime();
        Calendar.getInstance().setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("");// parse format
    }

    @Test
    public void demo() {

        try {

            String name = "com.twotiger.touch.controller.TouchController";

            String name2 = "com.twotiger.touch.controller.TouchController3";

            Class clazz = Class.forName(name2);
            Method[] methods = clazz.getDeclaredMethods();
            String[] str = new String[methods.length];
            for (int i = 0; i < methods.length; i++) {
                str[i] = methods[i].getName();
            }
            Arrays.sort(str);
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public boolean isEqual(String[] s) {
        for (String ss : s) {
            if (!s[0].equals(ss)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test10() {

        int a = 10;
        while (a == 10) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals(""))
                continue;
            if (str.equals("close")) {
                sc.close();
                return;
            }
            String[] strs = str.split(" ");
            cash(new BigDecimal(strs[0]), new BigDecimal(strs[1]));
        }
    }

    private void cash(BigDecimal amount, BigDecimal totalAmount) {

        /** 活动期间，每次投资判断和投资前相比累计投资额/1w的值是否增加，如果增加x（1，n）,则发放x个10元现金红包  */
        BigDecimal prevAmount = totalAmount.subtract(amount);
        BigDecimal prevTimes = prevAmount.divide(new BigDecimal("10000"), 0, BigDecimal.ROUND_DOWN);
        BigDecimal totalTimes = totalAmount.divide(new BigDecimal("10000"), 0,
            BigDecimal.ROUND_DOWN);
        int sum = totalTimes.subtract(prevTimes).intValue();
        System.err.println("以前的次数：" + prevTimes + "总次数：" + totalTimes + "增加次数：" + sum);
        //发放10元现金红包
    }

    public int getTigerCoinByInvest(BigDecimal investAmt) {
        if (investAmt.compareTo(new BigDecimal("500000")) == 1) {
            BigDecimal other = investAmt.subtract(new BigDecimal("500000"));
            return other.divide(new BigDecimal("10000"), RoundingMode.DOWN).intValue() * 2
                   + getTigerCoinByInvest(new BigDecimal("500000"));
        } else {
            int[][] table = { { 5000, 1 }, { 10000, 2 }, { 30000, 4 }, { 50000, 5 },
                             { 100000, 12 }, { 200000, 24 }, { 300000, 26 }, { 500000, 54 } };
            int coin = 0;
            for (int i = 0; i < table.length; i++) {
                if (investAmt.compareTo(new BigDecimal(table[i][0] + "")) >= 0) {
                    coin += table[i][1];
                    continue;
                }
                break;
            }
            return coin;
        }
    }

    @Test
    public void test9() {
        int a = 10;
        while (a == 10) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals(""))
                continue;
            if (str.equals("close")) {
                sc.close();
                return;
            }
            System.out.println("当您的投资额为时" + str + "，获得的币数是："
                               + getTigerCoinByInvest(new BigDecimal(str)));
        }
    }

    public BigDecimal[] getMayTigerCoin(BigDecimal investAmt) {
        BigDecimal[] info = new BigDecimal[2];
        if (investAmt.compareTo(new BigDecimal("500000")) >= 0) {
            info[0] = investAmt.divide(new BigDecimal("10000"), 0, RoundingMode.FLOOR)
                .multiply(new BigDecimal("10000")).add(new BigDecimal("10000"));
            info[1] = new BigDecimal("2");
        } else {
            int[][] table = { { 5000, 1 }, { 10000, 2 }, { 30000, 4 }, { 50000, 5 },
                             { 100000, 12 }, { 200000, 24 }, { 300000, 26 }, { 500000, 54 } };
            for (int i = 0; i < table.length; i++) {
                if (investAmt.compareTo(new BigDecimal(table[i][0] + "")) == -1) {
                    info[0] = new BigDecimal(table[i][0]);
                    info[1] = new BigDecimal("" + table[i][1]);
                    break;
                }
            }
        }
        return info;
    }

    @Test
    public void test11() {
        int a = 10;
        while (a == 10) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals(""))
                continue;
            if (str.equals("close")) {
                sc.close();
                return;
            }
            BigDecimal[] info = getMayTigerCoin(new BigDecimal(str));
            System.out.println("当您的投资额为时" + str + "，如投资到：" + info[0] + "可以再获得" + info[1]);
        }
    }

    @Test
    public void test12() {

        List l = new ArrayList();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");

        Iterator it = l.iterator();
        int a = 0;

        while (it.hasNext()) {
            a++;
            Object o = it.next();
            if (a == 2)
                it.remove();
        }
        for (Object li : l) {
            System.out.println(li);
        }
    }

    public BigDecimal getAwardAmountAct16_12_2(BigDecimal sum) {

        if (sum.compareTo(new BigDecimal("10000")) == -1)
            return BigDecimal.ZERO;
        BigDecimal amount = sum.divide(new BigDecimal("10000"), 0, RoundingMode.FLOOR).multiply(
            new BigDecimal("10000"));
        if (sum.compareTo(new BigDecimal("100000")) == 1) {
            return amount.multiply(new BigDecimal("45")).divide(new BigDecimal("10000"));
        } else if (sum.compareTo(new BigDecimal("50000")) == 1) {
            return amount.multiply(new BigDecimal("40")).divide(new BigDecimal("10000"));
        } else {
            return amount.multiply(new BigDecimal("35")).divide(new BigDecimal("10000"));
        }
    }

    @Test
    public void test13() {

        int a = 10;
        while (a == 10) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals(""))
                continue;
            if (str.equals("close")) {
                sc.close();
                return;
            }
            System.out.println(getAwardAmountAct16_12_2(new BigDecimal(str)));
        }

    }

    public boolean isComplete(long awardCount, long awardUseCount, long day, long dif) {

        long[] amount = new long[(int) day];
        long number = awardCount / day;
        long remainder = awardCount % day;
        long sumAmt = 0;
        for (int i = 0; i < amount.length; i++) {
            amount[i] = number;
        }
        for (int i = 0; i < remainder; i++) {
            amount[i]++;
        }
        for (int i = 0; i < dif; i++) {
            sumAmt += amount[i];
        }
        return awardUseCount >= sumAmt;
    }

    @Test
    public void test14() {

        int a = 10;
        while (a == 10) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals(""))
                continue;
            if (str.equals("close")) {
                sc.close();
                return;
            }
            String[] strs = str.split(" ");
            System.out.println(isComplete(Long.parseLong(strs[0]), Long.parseLong(strs[1]),
                Long.parseLong(strs[2]), Long.parseLong(strs[3])));
        }

    }

    @Test
    public void test15() {

        BigDecimal amount = new BigDecimal("12000.33");
        System.out.println(amount.divide(new BigDecimal("10")));
    }

    @Test
    public void 数组翻转() {

        String[][] info = { { "200000", "6" }, { "100000", "5" }, { "50000", "4" },
                           { "30000", "3" }, { "10000", "2" }, { "5000", "1" } };

    }

    public int getChanceAct_16_12_3(BigDecimal amount) {

        //大于20w每增加5w，增加一次机会
        if (amount.compareTo(new BigDecimal("200000")) == 1) {
            BigDecimal other = amount.subtract(new BigDecimal("200000"));
            return getChanceAct_16_12_3(new BigDecimal("200000"))
                   + other.divide(new BigDecimal("50000"), 0, RoundingMode.FLOOR).intValue();
        } else {
            String[][] info = { { "200000", "6" }, { "100000", "5" }, { "50000", "4" },
                               { "30000", "3" }, { "10000", "2" }, { "5000", "1" } };
            for (int i = 0; i < info.length; i++) {
                if (amount.compareTo(new BigDecimal(info[i][0])) >= 0)
                    return Integer.parseInt(info[i][1]);
            }
            return 0;
        }
    }

    @Test
    public void test16() {

        for (int i = 0; i < 100000; i++) {
            String str = String.valueOf(Math.random() * 300000);
            System.out.println(str + "  ''''''    " + getChanceAct_16_12_3(new BigDecimal(str)));
        }

    }

    public BigDecimal getNewChance(BigDecimal amount) {

        String[][] info = { { "200000", "6" }, { "100000", "5" }, { "50000", "4" },
                           { "30000", "3" }, { "10000", "2" }, { "5000", "1" } };
        if (amount.compareTo(new BigDecimal("200000")) >= 0) {
            return new BigDecimal("50000").subtract(amount.divideAndRemainder(new BigDecimal(
                "50000"))[1]);
        } else {
            for (int i = 0; i < info.length; i++) {
                if (amount.compareTo(new BigDecimal(info[info.length - 1 - i][0])) < 0) {
                    return new BigDecimal(info[info.length - 1 - i][0]).subtract(amount);
                }
            }
            return BigDecimal.ZERO;
        }
    }

    @Test
    public void test17() {
        for (int i = 0; i < 100000; i++) {
            String str = String.valueOf(Math.random() * 300000);
            System.out.println(str + "  ''''''    " + getNewChance(new BigDecimal(str)));
        }
    }

    @Test
    public void test18() {
        Map<String, Object> result = new HashMap<String, Object>();
        if (result.size() == 0) {
            System.out.println("0000");
        }
    }

    @Test
    public void test19() {
        System.out.println(new BigDecimal("1211100").multiply(new BigDecimal("0.001")).setScale(2,
            RoundingMode.HALF_UP));
    }

    @Test
    public void test20() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        for (int i = 0; i < 8; i++) {
            list.set(i, "444");
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(list.get(i));
        }

    }

    //计算两个时间的时间差，秒为单位
    @Test
    public void test21() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Calendar c2 = Calendar.getInstance();

        System.out.println((c.getTime().getTime() - c2.getTime().getTime()) / 1000);

    }

    //
    @Test
    public void test22() {
        BigDecimal awardValue = new BigDecimal("2200000").divide(new BigDecimal("9125"), 2,
            RoundingMode.HALF_UP);

        System.out.println(awardValue);

    }

    //券信息可视化工具
    @Test
    public void test23() {
        String[][] quanInfos = new String[][] { { "5", "1", "5000" }, { "10", "1", "8000" },
                                               { "18", "1", "10000" }, { "48", "1", "30000" },
                                               { "88", "1", "50000" }, { "188", "1", "100000" },
                                               { "488", "1", "200000" }, { "988", "1", "500000" } };

        for (int i = 0; i < quanInfos.length; i++) {
            System.out.println(quanInfos[i][0] + "元"
                               + (quanInfos[i][1].equals("1") ? "代金券" : "加息券")
                               + (quanInfos[i].length > 2 ? quanInfos[i][2] + "元限额" : ""));
        }

        String[][] quanInfos2 = new String[][] { { "0.1", "2", "2000" }, { "0.2", "2", "2000" },
                                                { "0.4", "2", "2000" }, { "0.6", "2", "2000" },
                                                { "0.8", "2", "2000" } };
        for (int i = 0; i < quanInfos2.length; i++) {
            System.out.println(quanInfos2[i][0] + "元"
                               + (quanInfos2[i][1].equals("1") ? "代金券" : "加息券")
                               + (quanInfos2[i].length > 2 ? quanInfos2[i][2] + "元限额" : ""));
        }

    }

    @Test
    public void test24() {
        String dateStr = DateUtil.getSystemTime("yyyyMMdd");
        System.out.println(DateUtil.format(dateStr + "000000000") + "       "
                           + DateUtil.format(dateStr + "235959000"));

    }

    public static void main(String[] args) {
        //    System.out.println("Hello World!");
        //控制天数
        String[] a = { "9", "11", "14", "16", "19", "21" };
        String[] b = { "26", "27", "28", "29", "30", "31" };
        for (int m = 0; m < 6; m++) {
            for (int i = 0; i < 6; i++) {
                for (int j = 1; j <= 4; j++) {
                    if (j == 1) {
                        System.out
                            .println("INSERT INTO `act_record` VALUES ('"
                                     + ((i * 4) + j + m * 24)
                                     + "', 'act_16_8_4_"
                                     + b[m]
                                     + ""
                                     + a[i]
                                     + "', '1', '0', '3', '20160823100002791', '20160823100002791');");
                    } else if (j == 2) {
                        System.out
                            .println("INSERT INTO `act_record` VALUES ('"
                                     + ((i * 4) + j + m * 24)
                                     + "', 'act_16_8_4_"
                                     + b[m]
                                     + ""
                                     + a[i]
                                     + "', '2', '0', '2', '20160823100002791', '20160823100002791');");
                    } else if (j == 3) {
                        System.out
                            .println("INSERT INTO `act_record` VALUES ('"
                                     + ((i * 4) + j + m * 24)
                                     + "', 'act_16_8_4_"
                                     + b[m]
                                     + ""
                                     + a[i]
                                     + "', '5', '0', '1', '20160823100002791', '20160823100002791');");
                    } else {
                        System.out
                            .println("INSERT INTO `act_record` VALUES ('"
                                     + ((i * 4) + j + m * 24)
                                     + "', 'act_16_8_4_"
                                     + b[m]
                                     + ""
                                     + a[i]
                                     + "', '10', '0', '1', '20160823100002791', '20160823100002791');");
                    }
                }
            }
        }
    }

    @Test
    public void hehehehe() {

        BigDecimal b = new BigDecimal("200");

        Long x = 10L;
        Long d = 10L;

        if (b == null || x != d) {
            System.out.println("ss");
        }

    }

    @Test
    public void hehehehe2() {

        long x = 145646546;
        Long d = 145646546L;
        System.out.println(x == d);
    }

    public void parse(long time) {
        String timeStr = time + "";
        System.out.println(timeStr.replaceAll(
            "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{3})", "$1年$2月$3日$4:$5:$6 $7毫秒"));
    }

    @Test
    public void parseTest() {
        long l = 20170301130000000L;
        parse(l);
    }

    @Test
    public void testAct_17_2_2() {

        for (int i = 0; i < 1000; i++) {
            String str = String.valueOf((int) 550000);
            BigDecimal[] list = act_17_2_2Return(new BigDecimal(str));
            System.out.println("投资额" + str + " 返现额 " + list[0] + " 代金券额 " + list[1]);

        }

    }

    public BigDecimal[] act_17_2_2Return(BigDecimal amount) {

        String[] info1 = { "5000", "20000", "40000", "80000", "100000", "120000", "160000",
                          "200000", "500000" };
        String[] info2 = { "8", "28", "58", "108", "138", "168", "228", "288", "698" };
        String[] info3 = { "6", "8", "14", "50", "80", "108", "188", "220", "290" };
        int index = getLevelIndex(amount, info1);
        if (index == 0) {
            return new BigDecimal[] { BigDecimal.ZERO, BigDecimal.ZERO };
        } else {
            return new BigDecimal[] { new BigDecimal(info2[index - 1]),
                                     new BigDecimal(info3[index - 1]) };
        }
    }

    public int getLevelIndex(BigDecimal amount, String[] info) {
        for (int i = 0; i < info.length; i++) {
            BigDecimal amt = new BigDecimal(info[i]);
            if (amt.compareTo(amount) == 1)
                return i;
        }
        return info.length;
    }

    @Test
    public void test() {

        System.out.println(inviteFriendAward3(new BigDecimal("30222")));

    }

    public BigDecimal inviteFriendAward3(BigDecimal amount) {

        if (amount.compareTo(new BigDecimal("500000")) == 1) {
            return amount.subtract(new BigDecimal("500000"))
                .divide(new BigDecimal("10000"), 0, BigDecimal.ROUND_DOWN)
                .multiply(new BigDecimal("50")).add(inviteFriendAward3(new BigDecimal("500000")));
        } else if (amount.compareTo(new BigDecimal("100000")) == 1) {
            return amount.subtract(new BigDecimal("100000"))
                .divide(new BigDecimal("10000"), 0, BigDecimal.ROUND_DOWN)
                .multiply(new BigDecimal("40")).add(inviteFriendAward3(new BigDecimal("100000")));
        } else if (amount.compareTo(new BigDecimal("50000")) == 1) {
            return amount.subtract(new BigDecimal("50000"))
                .divide(new BigDecimal("10000"), 0, BigDecimal.ROUND_DOWN)
                .multiply(new BigDecimal("30")).add(inviteFriendAward3(new BigDecimal("50000")));
        } else {
            return amount.divide(new BigDecimal("10000"), 0, BigDecimal.ROUND_DOWN).multiply(
                new BigDecimal("20"));
        }
    }
    
    public String getinviteFriend3AwardAmt(long registTime) {

        long level1Time = DateUtil.getDateAfterPeriodPrecise(registTime, 7);
        long level2Time = DateUtil.getDateAfterPeriodPrecise(registTime, 30);
        long sysTime = DateUtil.getSystemTimeForLong();
        if (sysTime < level1Time) {
            return "25";
        } else if (sysTime < level2Time) {
            return "15";
        } else {
            return "10";
        }
    }
    
    @Test
    public void testDark() {

        DateUtil.getDateForLong(String.valueOf(20170224110915608L), DateUtil.L_FMT, DateUtil.DATE_FMT);
        
    }
    
    
    
}
