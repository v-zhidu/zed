package com.tribes.algorithms.utils;

/**
 * 数组常用工具方法
 *
 * @author Zhiqiang Du
 */
public class ArrayUtil {

    /**
     * 找出数组中最大的元素
     *
     * @param a 整型类型数组
     * @return 最大元素
     */
    public static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        return max;
    }

    /**
     * 计算数组平均值
     *
     * @param a 整型类型数组
     * @return 平均值
     */
    public static double mean(int[] a) {
        int N = a.length;
        double sum = 0.0;

        for (int anA : a) {
            sum += anA;
        }

        return sum / N;
    }

    /**
     * 拷贝数组
     *
     * @param a 整型类型数组
     * @return 新数组
     */
    public static int[] duplicate(int[] a) {
        int N = a.length;
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            b[i] = a[i];
        }
        //System.arraycopy(a, 0, b, 0, N);

        return b;
    }

    /**
     * 反转字符串
     *
     * @param arr 字符串数组
     * @return 反转后的字符串
     */
    public static String reverse(char[] arr) {
        int N = arr.length;
        for (int i = 0; i < N / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[N-i-1];
            arr[N-i-1] = temp;
        }

        return String.valueOf(arr);
    }
}
