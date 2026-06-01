package com.lip.hello.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class HungryTypeTest {

    @Test
    void getInstanceReturnsSameObject() {
        HungryType first = HungryType.getInstance();
        HungryType second = HungryType.getInstance();
        assertSame(first, second);
    }
}
