package com.tribes.algorithms.sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 插入排序算法
 *
 * @param <T> 待排序元素的数据类型, 需实现了<code>Comparable</code> 接口
 * @see Sorting 通用算法接口
 * @see Comparable 比较接口
 */
public class InsertionSorting<T extends Comparable<T>> extends Sorting<T> {

    /**
     * 排序算法
     *
     * @param array 基于值的集合
     */
    @Override
    public void sort(T[] array) {
        super.startSorting();
        // 算法实现
        for (int i=1; i < array.length; i++) {
            int j = i - 1;
            T value = array[i];
            while (j >= 0 && value.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
                super.setModifyCount(1);
            }
            array[j + 1] = value;
        }
        super.endSorting();
    }

    /**
     * 排序算法
     *
     * @param array 基于指针的集合
     */
    @Override
    public void sort(LinkedList<T> array) {
        throw new UnsupportedOperationException("sort");
    }

    /**
     * 单元测试方法
     */
    public static void main(String[] args) {
        InsertionSorting<Integer> sorting = new InsertionSorting<Integer>();
        Integer[] array = new Integer[]{3, 1, 2, 4, 10, 2, 3, 5, 6, 7, 22, 111, 132};
        sorting.sort(array);

        StdOut.println(sorting.toString());
        StdOut.print(Arrays.toString(array));
    }
}
