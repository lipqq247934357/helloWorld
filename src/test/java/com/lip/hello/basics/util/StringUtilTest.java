package com.lip.hello.basics.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

    @Test
    void masksIdCard() {
        String masked = StringUtil.maskIDCard("142731199301095733");
        assertTrue(masked.contains("********"));
    }
}
