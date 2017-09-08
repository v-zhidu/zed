package com.tribes.algorithms.utils;

import com.tribes.algorithms.sorting.common.AscIntegerComparator;
import com.tribes.algorithms.sorting.common.DescIntegerComparator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

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

    /**
     * 在数组中的某一个位置插入元素
     *
     * @param array 待插入数组
     * @param index 插入元素的索引位置
     * @param value 插入元素
     */
    public static void insert(Object[] array, int index, Comparable value) {
        System.arraycopy(array, index, array, index + 1, array.length - 1 - index);
        array[index] = value;
    }

    /**
     * 交换数组中两个位置的元素
     *
     * @param i 元素索引
     * @param j 元素索引
     */
    public static void swap(Object[] array, int i, int j) {
        if (i == j)
            return;
        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 生成大小为n的随机数组
     *
     * @param n 数组大小
     * @return 生成大小为n的随机数组
     */
    public static Integer[] randomInt(int n) {
        Integer[] random = new Integer[n];
        for (int i = 0; i < n; i++)
            random[i] = StdRandom.uniform(n);

        return random;
    }

    /**
     * 生成大小为n的接近有序数组
     *
     * @param n 数组大小
     * @return 生成大小为n的接近有序数组
     */
    public static Integer[] nearlyInt(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++)
            array[i] = i;

        final int randomSize = (int) (n * 0.1);
        for (int i = 0; i < randomSize; i++) {
            int randomIndex = StdRandom.uniform(0, n);
            array[randomIndex] = StdRandom.uniform(0, n);
        }

        return array;
    }

    /**
     * 生成大小为n的升序获降序数组
     *
     * @param n 数组大小
     * @return 生成大小为n的升序获降序数组
     */
    public static Integer[] sortedInt(int n, Comparator comparator) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++)
            array[i] = i;
        Arrays.sort(array, comparator);
        return array;
    }

    /**
     * 重新排列数组中元素的大小
     *
     * @param array 待排列数组
     */
    public static void shuffle(Object[] array) {
        StdRandom.shuffle(array);
    }

    /**
     * 控制台输出
     *
     * @param array 待输出数组
     */
    public static void show(Object[] array) {
        StdOut.println(Arrays.toString(array));
    }
}
