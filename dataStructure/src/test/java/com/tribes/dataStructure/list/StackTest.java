package com.tribes.dataStructure.list;

import org.junit.Test;

public class StackTest {

    @Test
    public void testFixedCapacityStackOfStrings() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
        Character[] items = new Character[]{'c', 'c', '-', 'e', 'a', '-'};
    }
}
