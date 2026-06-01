package com.lip.hello.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexUtilTest {

    @Test
    void masksPhoneMiddleDigits() {
        assertTrue(RegexUtil.phoneIntervalAddStar("18903592838").contains("****"));
    }

    @Test
    void validatesMobileNumber() {
        assertTrue(RegexUtil.testPhone("18903592838"));
        assertFalse(RegexUtil.testPhone("12345"));
    }
}
