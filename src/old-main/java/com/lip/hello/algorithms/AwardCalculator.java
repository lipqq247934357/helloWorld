package com.lip.hello.algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class AwardCalculator {

    public List<String> getAwardQuan(BigDecimal investAmount, String[][] info) {
        BigDecimal maxAmount = new BigDecimal(info[info.length - 1][0]);
        BigDecimal minAmount = new BigDecimal(info[0][0]);
        BigDecimal[] awardAmount4Separator = investAmount.divideAndRemainder(maxAmount);
        BigDecimal times = awardAmount4Separator[0];
        BigDecimal award = awardAmount4Separator[1];
        int count = times.intValue();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(info[info.length - 1][1]);
        }
        if (award.compareTo(minAmount) >= 0) {
            for (int i = 1; i < info.length; i++) {
                BigDecimal amount = new BigDecimal(info[i][0]);
                if (award.compareTo(amount) < 0) {
                    list.add(info[i - 1][1]);
                    break;
                }
            }
        }
        return list;
    }

    public List<BigDecimal> getAwardAmount(BigDecimal investAmount, String[][] info) {
        List<BigDecimal> result = new ArrayList<>(3);
        BigDecimal maxAmount = new BigDecimal(info[info.length - 1][0]);
        if (investAmount.compareTo(maxAmount) >= 0) {
            List<BigDecimal> remainder = getAwardAmount(investAmount.subtract(maxAmount), info);
            result.add(new BigDecimal(info[info.length - 1][1]).add(remainder.get(0)));
            result.add(remainder.get(1));
            result.add(new BigDecimal(info[info.length - 1][1]).add(remainder.get(2)));
            return result;
        }

        BigDecimal awardAmount = BigDecimal.ZERO;
        BigDecimal difAmount = BigDecimal.ZERO;
        BigDecimal mayAwardAmount = BigDecimal.ZERO;
        for (int i = 0; i < info.length; i++) {
            BigDecimal amount = new BigDecimal(info[i][0]);
            if (investAmount.compareTo(amount) < 0) {
                awardAmount = i == 0 ? BigDecimal.ZERO : new BigDecimal(info[i - 1][1]);
                difAmount = amount.subtract(investAmount).setScale(2, RoundingMode.HALF_UP);
                mayAwardAmount = new BigDecimal(info[i][1]);
                break;
            }
        }
        result.add(awardAmount);
        result.add(difAmount);
        result.add(mayAwardAmount);
        return result;
    }

    public int getLevel(BigDecimal amount, String[] rank) {
        int level = rank.length + 1;
        for (int curFloor = 1; curFloor <= rank.length; curFloor++) {
            BigDecimal roof = new BigDecimal(rank[curFloor - 1]);
            if (amount.compareTo(roof) < 0) {
                level = curFloor;
                break;
            }
        }
        return level;
    }
}
