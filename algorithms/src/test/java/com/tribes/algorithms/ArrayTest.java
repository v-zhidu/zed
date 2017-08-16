package com.tribes.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.tribes.algorithms.Array.*;

/**
 * Created by duzhiqiang on 2017/6/15.
 * 数组类测试方法
 */
public class ArrayTest {

    @Test
    public void testMax() {
        int[] a = {1, 3, 4, 5, 6, 2, 11, 5};

        assertEquals(11, max(a));
    }

    @Test
    public void testAverage() {
        int[] a = {1, 3, 4, 5, 6, 2, 11, 5};

        assertEquals((double) 37 / 8, average(a), 0.0);
    }

    @Test
    public void testDuplicate() {
        int[] a = {1, 3, 4, 5, 6, 2, 11, 5};

        assertArrayEquals(a, duplicate(a));
    }

    @Test
    public void testReverse(){
        String str = "abcd";

        assertEquals("dcba", "dcba", reverse(str.toCharArray()));
    }
}
