package com.tribes.algorithms.sorting;

import com.tribes.algorithms.sorting.common.Sorting;
import com.tribes.algorithms.utils.ArrayUtil;
import com.tribes.dataStructure.list.LinkedList;
import edu.princeton.cs.algs4.Selection;

import java.util.Comparator;

public class SelectionSorting<T extends Comparable> extends Sorting<T> {
    /**
     * 基本的算法实现
     * <p>
     * 用来实现一般教材中的基本算法实现
     *
     * @param array 整型类型数组
     */
    @Override
    public void sort(Comparable[] array) {
        startSorting(array.length);

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (less(array[j], array[i]))
                    ArrayUtil.swap(array, i, j);
            }
        }

        endSorting();
    }

    /**
     * 支持升序或降序排列的算法
     *
     * @param array      基于值的集合
     * @param comparator
     */
    @Override
    public void sort(Comparable[] array, Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    /**
     * 支持升序或降序排列的算法
     *
     * @param list       基于指针的集合
     * @param comparator
     */
    @Override
    public void sort(LinkedList<Comparable> list, Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        SelectionSorting<Comparable> sorting = new SelectionSorting<>();

        sorting.evaluate(new Integer[]{10, 100, 500}, 10);
    }
}
