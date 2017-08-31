package com.tribes.dataStructure.list;

public class FixedCapacityStackOfStrings {
    private String[] a;

    private int n;

    FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(String e) {
        a[n++] = e;
    }

    public String pop() {
        return a[--n];
    }
}
