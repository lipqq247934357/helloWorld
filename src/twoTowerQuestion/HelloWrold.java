package twoTowerQuestion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class HelloWrold {

    @Test
    public void test10() {

        String[][] info = { { "10000", "20" }, { "30000", "60" }, { "50000", "110" },
                           { "100000", "240" }, { "200000", "520" } };
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
            BigDecimal investAmount = new BigDecimal(str);
            List<String> list = getAwardQuan(investAmount, info);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");
            }
            System.out.println();
        }
    }

    public List<String> getAwardQuan(BigDecimal investAmount, String[][] info) {

        //一轮最大的投资金额
        BigDecimal maxAmount = new BigDecimal(info[info.length - 1][0]);
        //最小的发券金额
        BigDecimal minAmount = new BigDecimal(info[0][0]);
        BigDecimal[] awardAmount4Separator = investAmount.divideAndRemainder(maxAmount);
        BigDecimal times = awardAmount4Separator[0];//整数位
        BigDecimal award = awardAmount4Separator[1];//余数
        int a = times.intValue();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < a; i++) {
            list.add(info[info.length - 1][1]);
        }
        if (award.compareTo(minAmount) >= 0) {
            for (int i = 1; i < info.length; i++) {
                BigDecimal amount = new BigDecimal(info[i][0]);
                if (award.compareTo(amount) == -1) {
                    BigDecimal awardAmount = new BigDecimal(info[i - 1][1]);
                    list.add(String.valueOf(awardAmount));
                    break;
                }
            }
        }
        return list;
    }

    @Test
    public void test11() {

        String[][] info = { { "10000", "20" }, { "30000", "60" }, { "50000", "110" },
                           { "100000", "240" }, { "200000", "520" } };
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
            BigDecimal investAmount = new BigDecimal(str);
            List<String> list = getAwardQuan(investAmount, info);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void test9() {

        String[][] info = { { "10000", "20" }, { "30000", "60" }, { "50000", "110" },
                           { "100000", "240" }, { "200000", "520" } };
        int a = 10;
        while (a == 10) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals("close")) {
                return;
            }
            BigDecimal amount = new BigDecimal(str);
            List<BigDecimal> list = getAwardAmount(amount, info);
            System.out.println("awardAmount(已经获得的现金红包)" + list.get(0));
            //            System.out.println("difAmount(还差多少钱可以获得现金红包)" + list.get(1));
            //            System.out.println("mayAwardAmount（获得多少元现金红包）" + list.get(2));

        }

    }

    public static List<BigDecimal> getAwardAmount(BigDecimal investAmount, String[][] info) {
        ArrayList<BigDecimal> result = new ArrayList<BigDecimal>();
        BigDecimal difAmount = new BigDecimal("0");
        BigDecimal awardAmount = new BigDecimal("0");
        BigDecimal mayAwardAmount = new BigDecimal("0");
        //一轮最大的投资金额
        BigDecimal maxAmount = new BigDecimal(info[info.length - 1][0]);
        if (investAmount.compareTo(maxAmount) >= 0) {
            List<BigDecimal> amount = getAwardAmount(investAmount.subtract(maxAmount), info);
            difAmount = amount.get(1);
            awardAmount = new BigDecimal(info[info.length - 1][1]).add(amount.get(0));
            mayAwardAmount = new BigDecimal(info[info.length - 1][1]).add(amount.get(2));
        } else {
            for (int i = 0; i < info.length; i++) {
                BigDecimal amount = new BigDecimal(info[i][0]);
                if (investAmount.compareTo(amount) == -1) {
                    awardAmount = (i == 0 ? BigDecimal.ZERO : new BigDecimal(info[i - 1][1]));
                    difAmount = amount.subtract(investAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    mayAwardAmount = new BigDecimal(info[i][1]);
                    break;
                }
            }
        }
        result.add(awardAmount);
        result.add(difAmount);
        result.add(mayAwardAmount);
        return result;
    }

    public int getLevel(BigDecimal amount, String[] rank) {
        int level = rank.length + 1;//默认是超过最大值
        for (int curFloor = 1; curFloor <= rank.length; curFloor++) {
            BigDecimal roof = new BigDecimal(rank[curFloor-1]);
            if (amount.compareTo(roof) == -1) {
                level = curFloor;
                break;
            }
        }
        return level;
    }

    @Test
    public void test() {

        String[] rank = { "10000", "50000", "100000", "200000", "300000", "1000000" };
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
            BigDecimal investAmount = new BigDecimal(str);
            int level = getLevel(investAmount, rank);
            System.out.print(level);
            System.out.println();
        }

    }
    
    /**
     * 给你两个数组和一个值，获取这个值在第一个数组中大于的最大数位置，再获取这个位置在另一个数组中的元素
     * 默认小于 var rateInfo = [0.2,0.6,0.9,1.2];var level = [2000,10000,200000,100000000];
     * int[1,2,3,4,5],int[6,7,8,9,10],
     * 
     * @param firstArray
     * @param secondArray
     * @param num
     * @param mapZero 就是在第一个数组的0 -- first[0]之间是否对应第二个数组的第一个元素,
     */
    
    public int twoTigerQuestion(int[] firstArray, int[] secondArray, int num,boolean mapZero){
        
        
        /**
         * 思路：
         *      1.获取这个元素在第一个数组中的位置
         *      2.判断小于第一个数字的部分是否对应内容
         *      3.再获取在第二个数组中的位置
         */
        int floor = 0;
        
        
        
        return -1;
    }

}
