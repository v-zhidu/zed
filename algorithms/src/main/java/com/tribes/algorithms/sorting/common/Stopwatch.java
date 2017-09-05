package com.tribes.algorithms.sorting.common;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigDecimal;

/**
 * 计时器
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        this.start = System.nanoTime();
    }

    public double elapsedTime() {
        BigDecimal decimal = BigDecimal.valueOf(System.nanoTime() - this.start, 10);
        return decimal.doubleValue();
    }

    public static void main(String[] args) {
       Stopwatch watch = new Stopwatch();
       StdOut.println(watch.elapsedTime());
    }
}
