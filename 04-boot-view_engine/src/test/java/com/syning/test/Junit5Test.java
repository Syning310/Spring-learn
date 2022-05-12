package com.syning.test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Test {

    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int add = add(2, 3);

        assertEquals(3, 5);

    }

    int add(int a, int b) {
        return a + b;
    }

}








