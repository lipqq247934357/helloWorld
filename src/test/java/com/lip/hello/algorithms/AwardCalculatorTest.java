package com.lip.hello.algorithms;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AwardCalculatorTest {

    private static final String[][] INFO = {
        { "10000", "20" }, { "30000", "60" }, { "50000", "110" },
        { "100000", "240" }, { "200000", "520" }
    };

    @Test
    void getLevelReturnsExpectedFloor() {
        AwardCalculator calculator = new AwardCalculator();
        assertEquals(1, calculator.getLevel(new BigDecimal("5000"), rank()));
        assertEquals(3, calculator.getLevel(new BigDecimal("50000"), rank()));
        assertEquals(7, calculator.getLevel(new BigDecimal("2000000"), rank()));
    }

    @Test
    void getAwardQuanHandlesLargeInvestment() {
        AwardCalculator calculator = new AwardCalculator();
        assertEquals(2, calculator.getAwardQuan(new BigDecimal("250000"), INFO).size());
    }

    private String[] rank() {
        return new String[] { "10000", "50000", "100000", "200000", "300000", "1000000" };
    }
}
