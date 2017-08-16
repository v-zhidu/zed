package com.tribes.algorithms;

/**
 * 常用的数学计算
 * @author v-zhidu
 * Created on 2017/6/20.
 */
public class Math {

    /*
    * 计算一个整数的绝对值
    * */
    public static int abs(int x) {
        if (x < 0) return -x;
        else return x;
    }

    /*
    * 计算一个浮点数的绝对值
    * */
    public static double abs(double x) {
        if (x < 0.0) return -x;
        else return x;
    }

    /*
    * 计算一个数是否是素数
    * 在大于1的自然数中，除了1和它本身没有其他因数
    * */
    public static boolean isPrime(int x) {
        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}