package com.tribes.algorithms;

/**
 * 数组常用工具方法
 *
 * @author Zhiqiang Du
 */
public class Array {

    /*
    * 找出数组中最大的元素
    * */
    static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        return max;
    }

    /*
    * 计算数组元素的平均值
    * */
    static double average(int[] a) {
        int N = a.length;
        double sum = 0.0;

        for (int anA : a) {
            sum += anA;
        }

        return sum / N;
    }

    /*
    * 复制数组
    * */
    static int[] duplicate(int[] a) {
        int N = a.length;
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            b[i] = a[i];
        }
        //System.arraycopy(a, 0, b, 0, N);

        return b;
    }

    /*
    * 反转字符串
    * */
    static String reverse(char[] arr) {
        int N = arr.length;
        for (int i = 0; i < N / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[N-i-1];
            arr[N-i-1] = temp;
        }

        return String.valueOf(arr);
    }
}
